package com.liudi.back.controller;

import com.alibaba.fastjson.JSON;
import com.liudi.back.core.base.WebController;
import com.liudi.back.dto.ElasticSearchRequestDto;
import com.liudi.back.dto.FilterCommand;
import com.liudi.back.dto.QueryCommand;
import com.liudi.back.es.service.EsSearch;
import com.liudi.back.utils.Message;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/es")
@Api(tags = "ElasticSearch")
@Slf4j
public class EsSeearchController extends WebController {

    @Autowired
    private EsSearch esSearch;


    @GetMapping("")
    public Message getEsSearchAll() {
        return this.getEsSearch("*");
    }

    @GetMapping("/{name}")
    public Message getEsSearch(@PathVariable("name") String name) {
        List<Object> data = new ArrayList<>();
        ElasticSearchRequestDto dto = new ElasticSearchRequestDto();
        QueryCommand query = new QueryCommand();

        query.setIndexname("sougoulog");
        query.setKeyWords(name);
        query.setRows(10);
        query.setStart((1-1)*10);
        query.setSort("id");
        dto.setQuery(query);

        SearchResponse searchResponse = esSearch.queryString(dto);
        log.info("========: {}", JSON.toJSONString(searchResponse));
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            Map<String, Object> highlights = new HashMap<String, Object>();
            Map<String, Object> map = hit.getSourceAsMap();
            // 获取高亮结果
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            for (Map.Entry<String, HighlightField> entry : highlightFields.entrySet()) {
                String mapKey = entry.getKey();
                HighlightField mapValue = entry.getValue();
                Text[] fragments = mapValue.fragments();
                String fragmentString = fragments[0].string();
                highlights.put(mapKey, fragmentString);
            }
            map.put("highlight", highlights);
            data.add(map);
        }
        return Message.success(data);
    }
}

package com.liudi.back.es.service.impl;

import com.liudi.back.config.EsClient;
import com.liudi.back.dto.ElasticSearchRequestDto;
import com.liudi.back.dto.FilterCommand;
import com.liudi.back.es.service.EsSearch;
import com.liudi.back.utils.ToolUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EsSearchImpl implements EsSearch {


    @Autowired
    RestHighLevelClient client;

    @Override
    public SearchResponse queryString(ElasticSearchRequestDto request) {
        SearchRequest searchRequest = new SearchRequest(request.getQuery().getIndexname());
        // 如果关键词为空，则返回所有
        String content = request.getQuery().getKeyWords();
        Integer rows = request.getQuery().getRows();
        if (rows == null || rows == 0) {
            rows = 10;
        }
        Integer start = request.getQuery().getStart();
        if (content == null || "".equals(content)) {
            // 查询所有
            content = "*";
        }
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 提取搜索内容
        BoolQueryBuilder builder;
        if("*".equalsIgnoreCase(content)){
            builder = QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery(content).defaultOperator(Operator.AND));
        }else {
            builder = QueryBuilders.boolQuery().must(QueryBuilders.queryStringQuery(ToolUtils.handKeyword(content)).defaultOperator(Operator.AND));
        }
        // 提取过滤条件
        FilterCommand filter = request.getFilter();
        if (filter != null) {
            if (filter.getStartdate()!=null&&filter.getEnddate()!=null) {
                builder.filter(QueryBuilders.rangeQuery(filter.getField()).from(filter.getStartdate()).to(filter.getEnddate()));
            }
        }
        // 排序
        if(StringUtils.isNoneBlank(request.getQuery().getSort())){
            searchSourceBuilder.sort(request.getQuery().getSort(), SortOrder.ASC);
        }
        // 查询全部
        searchSourceBuilder.trackTotalHits(true);
        searchSourceBuilder.query(builder);
        // 处理高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("*");
        searchSourceBuilder.highlighter(highlightBuilder);
        searchSourceBuilder.from(start);
        searchSourceBuilder.size(rows);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = null;
        try {
            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return searchResponse;
    }
}

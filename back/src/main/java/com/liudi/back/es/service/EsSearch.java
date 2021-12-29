package com.liudi.back.es.service;

import com.liudi.back.dto.ElasticSearchRequestDto;
import org.elasticsearch.action.search.SearchResponse;

public interface EsSearch {

    SearchResponse queryString(ElasticSearchRequestDto request);
}

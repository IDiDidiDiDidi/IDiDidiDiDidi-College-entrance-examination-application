package com.liudi.back.dto;

import lombok.Data;

@Data
public class ElasticSearchRequestDto {
    // 查询条件
    private QueryCommand query;
    // 过滤条件
    private FilterCommand filter;
}

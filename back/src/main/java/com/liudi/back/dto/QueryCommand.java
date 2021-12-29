package com.liudi.back.dto;

import lombok.Data;

@Data
public class QueryCommand {
    // 表名
    String indexname;
    //关键词
    private String keyWords;
    //搜索域
    private String search_field;
    //逻辑连接词
    private String operator;
    // 排序
    String sort;
    //起始位置
    private int start;
    //返回条数
    private int rows;
    //返回字段
    private String return_filed;

    String startdate;

    String enddate;
    // 聚集字段
    String aggsField;
    // 步长
    Integer step;
    // 滚动分页id
    String scrollid;
}

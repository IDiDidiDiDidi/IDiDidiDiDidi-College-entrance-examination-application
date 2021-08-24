package com.liudi.back.entity;

import lombok.Data;

@Data
public class BaiduMapLngLatBean {

    private String level;
    private String confidence;
    private Location location;
    private Integer precise;
    private Integer comprehension;
}

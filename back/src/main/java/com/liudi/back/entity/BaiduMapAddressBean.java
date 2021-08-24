package com.liudi.back.entity;

import lombok.Data;

@Data
public class BaiduMapAddressBean {
    private String formatted_address;
    private String business;
    private String sematic_description;
    private Integer cityCode;
    private Object roads;
    private Location location;
    private Object poiRegions;
    private Object pois;
    private AddressComponent addressComponent;
}

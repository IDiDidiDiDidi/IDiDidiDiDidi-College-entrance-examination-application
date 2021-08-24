package com.liudi.back.entity;

import lombok.Data;

@Data
public class AddressComponent {
    private Integer city_level;
    private String country;
    private String town;
    private String distance;
    private String city;
    private String adcode;
    private String country_code_iso;
    private String country_code_iso2;
    private Integer country_code;
    private String town_code;
    private String province;
    private String street;
    private String district;
    private String street_number;
    private String direction;
}

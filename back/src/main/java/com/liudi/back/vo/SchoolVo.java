package com.liudi.back.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SchoolVo对象", description = "学校VO")
public class SchoolVo {

    @ApiModelProperty(value = "schoolName")
    private String schoolName;

    @ApiModelProperty(value = "schoolNo")
    private String schoolNo;

    @ApiModelProperty(value = "address")
    private String address;

    @ApiModelProperty(value = "属性")
    private String attributes;
}

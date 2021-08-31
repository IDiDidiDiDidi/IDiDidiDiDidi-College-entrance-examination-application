package com.liudi.back.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ShandongBatchDeliveryVo对象", description = "搜索显示VO")
public class SmartSearchVo {
    @ApiModelProperty(value = "schoolNo")
    private String schoolNo;

    @ApiModelProperty(value = "院校")
    private String schoolName;

    @ApiModelProperty(value = "可选专业数量")
    private Integer count;

    @ApiModelProperty(value = "该校录取最低分")
    private String lowestScore;

    @ApiModelProperty(value = "该校录取最")
    private String lowestPosition;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "地址")
    private String year;
}

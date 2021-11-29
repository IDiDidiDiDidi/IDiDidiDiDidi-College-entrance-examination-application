package com.liudi.back.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MinMaxVo {
    @ApiModelProperty(value = "year")
    private String year;

    @ApiModelProperty(value = "max")
    private Integer max;

    @ApiModelProperty(value = "min")
    private Integer min;
}

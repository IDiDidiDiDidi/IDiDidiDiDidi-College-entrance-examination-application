package com.liudi.back.dto;

import com.liudi.back.utils.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ShandongBatchDeliveryDto对象", description = "搜索筛选")
public class SearchDto extends PageDto {
    @ApiModelProperty("成绩")
    private Integer score;

    @ApiModelProperty("分数范围")
    private Integer scoreRange;

    @ApiModelProperty("排名")
    private Integer rank;

    @ApiModelProperty("year")
    private String year;

    @ApiModelProperty("city_id")
    private String cityId;

    @ApiModelProperty("provinceId")
    private String provinceId;

    private String areaBaseId;
}

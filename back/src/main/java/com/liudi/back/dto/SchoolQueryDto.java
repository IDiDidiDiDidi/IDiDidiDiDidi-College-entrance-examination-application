package com.liudi.back.dto;

import com.liudi.back.utils.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SchoolQueryDto extends PageDto {

    @ApiModelProperty("学校姓名")
    private String schoolName;



}

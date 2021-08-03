package com.liudi.back.dto;

import com.liudi.back.utils.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "ShandongBatchDeliveryDto对象", description = "山东省普通类常规批第一次志愿投档情况")
public class ShandongBatchDeliverySearchDto extends PageDto {

    @ApiModelProperty("专业")
    private String major;
    @ApiModelProperty("专业")
    private String majorNo;
    @ApiModelProperty("院校")
    private String schoolName;
    @ApiModelProperty("院校")
    private String schoolNo;
    @ApiModelProperty("计划数")
    private String plansNumber;
    @ApiModelProperty("投档计划数")
    private String pitchPlansNumber;
    @ApiModelProperty("投出数")
    private String castNumber;
    @ApiModelProperty("最低分")
    private String lowestScore;
    @ApiModelProperty("最高分")
    private String highestScore;
    @ApiModelProperty("最低位次")
    private String lowestPosition;
    @ApiModelProperty("最高位次")
    private String highestPosition;
    @ApiModelProperty("year")
    private String year;
    @ApiModelProperty("分数范围")
    private String scoreRange;
}

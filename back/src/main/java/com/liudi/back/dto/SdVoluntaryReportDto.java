package com.liudi.back.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.liudi.back.utils.PageDto;
 import java.util.Date;
/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况Dto
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
 @Data
 @ApiModel(value = "SdVoluntaryReportDto对象", description = "山东省普通类常规批第一次志愿投档情况")
 public class SdVoluntaryReportDto extends PageDto {

    @ApiModelProperty("主键Id")
    private String baseId;
    @ApiModelProperty("创建时间")
    private Date baseCreateTime;
    @ApiModelProperty("更新时间")
    private Date baseUpdateTime;
    @ApiModelProperty("创建者")
    private String creator;
    @ApiModelProperty("逻辑删除（0:未删除,1:删除）")
    private Boolean isDelete;
    @ApiModelProperty("专业")
    private String major;
    @ApiModelProperty("专业")
    private String majorNo;
    @ApiModelProperty("院校")
    private String schoolName;
    @ApiModelProperty("院校编码")
    private String schoolNo;
    @ApiModelProperty("计划数")
    private Integer plansNumber;
    @ApiModelProperty("投档计划数")
    private Integer pitchPlansNumber;
    @ApiModelProperty("投出数")
    private Integer castNumber;
    @ApiModelProperty("最低分")
    private Double lowestScore;
    @ApiModelProperty("最高分")
    private Double highestScore;
    @ApiModelProperty("最低位次")
    private Integer lowestPosition;
    @ApiModelProperty("最高位次")
    private Integer highestPosition;
    @ApiModelProperty("year")
    private String year;
    @ApiModelProperty("投报批次")
    private Integer batch;
    @ApiModelProperty("层次")
    private String level;
}

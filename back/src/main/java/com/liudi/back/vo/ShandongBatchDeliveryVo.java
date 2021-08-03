package com.liudi.back.vo;
import java.util.Date;

import com.liudi.back.core.base.BaseVo;
import com.liudi.back.core.base.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况Vo
 * </p>
 *
 * @author LiuD
 * @since 2021-08-03
 */
@Data
@ApiModel(value = "ShandongBatchDeliveryVo对象", description = "山东省普通类常规批第一次志愿投档情况")
public class ShandongBatchDeliveryVo extends BaseVo {

    @ApiModelProperty(value = "主键Id")
    private String baseId;

    @ApiModelProperty(value = "创建时间")
    private Date baseCreateTime;

    @ApiModelProperty(value = "更新时间")
    private Date baseUpdateTime;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "逻辑删除（0:未删除,1:删除）")
    private Boolean isDelete;

    @ApiModelProperty(value = "专业")
    @ExcelProperty(name = "专业")
    private String major;

    @ApiModelProperty(value = "专业")
    private String majorNo;

    @ApiModelProperty(value = "院校")
    @ExcelProperty(name = "院校")
    private String schoolName;

    @ApiModelProperty(value = "院校")
    private String schoolNo;

    @ApiModelProperty(value = "计划数")
    @ExcelProperty(name = "计划数")
    private Integer plansNumber;

    @ApiModelProperty(value = "投档计划数")
    @ExcelProperty(name = "投档计划数")
    private Integer pitchPlansNumber;

    @ApiModelProperty(value = "投出数")
    @ExcelProperty(name = "投出数")
    private Integer castNumber;

    @ApiModelProperty(value = "最低分")
    @ExcelProperty(name = "最低分")
    private Double lowestScore;

    @ApiModelProperty(value = "最高分")
    private Double highestScore;

    @ApiModelProperty(value = "最低位次")
    @ExcelProperty(name = "最低位次")
    private Integer lowestPosition;

    @ApiModelProperty(value = "最高位次")
    private Integer highestPosition;

    @ApiModelProperty(value = "year")
    private String year;


}

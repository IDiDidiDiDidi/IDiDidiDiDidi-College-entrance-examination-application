package com.liudi.back.vo;

import com.liudi.back.core.base.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ImportSdExcelVo {

    @ApiModelProperty(value = "层次")
    @ExcelProperty(name = "层次")
    private String level;

    @ApiModelProperty(value = "专业")
    @ExcelProperty(name = "专业")
    private String major;

    @ApiModelProperty(value = "院校")
    @ExcelProperty(name = "院校")
    private String schoolName;

    @ApiModelProperty(value = "计划数")
    @ExcelProperty(name = "计划数")
    private int plansNumber;

    @ApiModelProperty(value = "投档计划数")
//    @ExcelProperty(name = "投档计划数")
    private int pitchPlansNumber;

    @ApiModelProperty(value = "投出数")
    @ExcelProperty(name = "投出数")
    private int castNumber;

    @ApiModelProperty(value = "最低分")
    @ExcelProperty(name = "最低分")
    private double lowestScore;

    @ApiModelProperty(value = "最低位次")
    @ExcelProperty(name = "最低位次")
    private int lowestPosition;
}

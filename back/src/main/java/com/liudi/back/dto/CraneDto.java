package com.liudi.back.dto;

import com.liudi.back.core.base.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 吊车详细配置Dto
 * </p>
 *
 * @author LiuD
 * @since 2021-10-09
 */
@Data
@ApiModel(value = "CraneDto对象", description = "吊车详细配置")
public class CraneDto extends PageDto {

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
    @ApiModelProperty("汽车吊/自制吊/orther")
    private String type;
    @ApiModelProperty("车名")
    private String name;
    @ApiModelProperty("吨位")
    private String tonnage;
    @ApiModelProperty("蓝牌、黄牌")
    private String licenseColour;
    @ApiModelProperty("是否自制")
    private String isSelfMade;
    @ApiModelProperty("副钩绞车")
    private String secondaryHookWinch;
    @ApiModelProperty("主钩绞车")
    private String mainHookWinch;
    @ApiModelProperty("底盘型号")
    private String chassisModel;
    @ApiModelProperty("底盘品牌")
    private String chassisBrand;
    @ApiModelProperty("减速机型号")
    private String reducerModel;
    @ApiModelProperty("最大起升高度")
    private String liftingHeight;
    @ApiModelProperty("回转支撑")
    private String slewingSupport;
    @ApiModelProperty("U型吊臂")
    private String uShapedBoom;
    @ApiModelProperty("液压系统")
    private String hydraulicSystem;
    @ApiModelProperty("支腿跨距（横*纵）")
    private String outriggerSpan;
    @ApiModelProperty("大架")
    private String bigFrame;
    @ApiModelProperty("外形尺寸")
    private String dimensions;
    @ApiModelProperty("后移位项")
    private String backShift;
    @ApiModelProperty("发动机型号")
    private String engineModel;
    @ApiModelProperty("方向形式")
    private String directionForm;
    @ApiModelProperty("发动机功率")
    private String enginePower;
    @ApiModelProperty("刹车形式")
    private String brakingForm;
    @ApiModelProperty("轮胎型号")
    private String tyreModel;
    @ApiModelProperty("变速箱")
    private String gearbox;
    @ApiModelProperty("行驶速度")
    private String speed;
    @ApiModelProperty("操作室")
    private String operatingRoom;
    @ApiModelProperty("轴距")
    private String wheelbase;
    @ApiModelProperty("实际/公告重量")
    private String weight;
    @ApiModelProperty("其他配置")
    private String otherConfiguration;
    @ApiModelProperty("选配")
    private String optional;
    @ApiModelProperty("")
    private String img;
    @ApiModelProperty("发动机三泵")
    private String engineThreePumps;
    @ApiModelProperty("电机")
    private String motorThreePumps;
    @ApiModelProperty("中心回转")
    private String centerRotation;
    @ApiModelProperty("电机功率")
    private String motorPower;
    @ApiModelProperty("起升速度（副主钩）")
    private Double liftingSpeed;
    @ApiModelProperty("大臂")
    private String bigArm;
    @ApiModelProperty("回转速度")
    private Double swingSpeed;
}

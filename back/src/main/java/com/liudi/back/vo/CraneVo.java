package com.liudi.back.vo;
import java.util.Date;

import com.liudi.back.core.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 吊车详细配置Vo
 * </p>
 *
 * @author LiuD
 * @since 2021-10-09
 */
@Data
@ApiModel(value = "CraneVo对象", description = "吊车详细配置")
public class CraneVo extends BaseVo {

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
    @ApiModelProperty(value = "车名")
    private String name;
    @ApiModelProperty(value = "type")
    private String type;
    @ApiModelProperty(value = "img")
    private String img;
    @ApiModelProperty(value = "吨位")
    private String tonnage;
    @ApiModelProperty(value = "蓝牌、黄牌")
    private String licenseColour;
    @ApiModelProperty(value = "是否自制")
    private String isSelfMade;
    @ApiModelProperty(value = "主钩绞车")
    private String mainHookWinch;
    @ApiModelProperty(value = "底盘型号")
    private String chassisModel;
    @ApiModelProperty(value = "底盘品牌")
    private String chassisBrand;
    @ApiModelProperty(value = "减速机型号")
    private String reducerModel;
    @ApiModelProperty(value = "最大起升高度")
    private String liftingHeight;
    @ApiModelProperty(value = "回转支撑")
    private String slewingSupport;
    @ApiModelProperty(value = "U型吊臂")
    private String uShapedBoom;
    @ApiModelProperty(value = "液压系统")
    private String hydraulicSystem;
    @ApiModelProperty(value = "支腿跨距（横*纵）")
    private String outriggerSpan;
    @ApiModelProperty(value = "大架")
    private String bigFrame;
    @ApiModelProperty(value = "外形尺寸")
    private String dimensions;
    @ApiModelProperty(value = "后移位项")
    private String backShift;
    @ApiModelProperty(value = "发动机型号")
    private String engineModel;
    @ApiModelProperty(value = "方向形式")
    private String directionForm;
    @ApiModelProperty(value = "发动机功率")
    private String enginePower;
    @ApiModelProperty(value = "刹车形式")
    private String brakingForm;
    @ApiModelProperty(value = "轮胎型号")
    private String tyreModel;
    @ApiModelProperty(value = "变速箱")
    private String gearbox;
    @ApiModelProperty(value = "行驶速度")
    private String speed;
    @ApiModelProperty(value = "操作室")
    private String operatingRoom;
    @ApiModelProperty(value = "轴距")
    private String wheelbase;
    @ApiModelProperty(value = "实际/公告重量")
    private String weight;
    @ApiModelProperty(value = "其他配置")
    private String otherConfiguration;
    @ApiModelProperty(value = "选配")
    private String optional;

}

package com.liudi.back.entity;

import com.liudi.back.core.base.InfoEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 吊车详细配置
 * </p>
 *
 * @author LiuD
 * @since 2021-10-09
 */
@Data
@TableName("crane")
public class Crane extends InfoEntity {
    /**
     * 汽车吊/自制吊/orther
     */
    private String type;
    /**
     * 车名
     */
    private String name;
    /**
     * 吨位
     */
    private String tonnage;
    /**
     * 蓝牌、黄牌
     */
    private String licenseColour;
    /**
     * 是否自制
     */
    private String isSelfMade;
    /**
     * 副钩绞车
     */
    private String secondaryHookWinch;
    /**
     * 主钩绞车
     */
    private String mainHookWinch;
    /**
     * 底盘型号
     */
    private String chassisModel;
    /**
     * 底盘品牌
     */
    private String chassisBrand;
    /**
     * 减速机型号
     */
    private String reducerModel;
    /**
     * 最大起升高度
     */
    private String liftingHeight;
    /**
     * 回转支撑
     */
    private String slewingSupport;
    /**
     * U型吊臂
     */
    private String uShapedBoom;
    /**
     * 液压系统
     */
    private String hydraulicSystem;
    /**
     * 支腿跨距（横*纵）
     */
    private String outriggerSpan;
    /**
     * 大架
     */
    private String bigFrame;
    /**
     * 外形尺寸
     */
    private String dimensions;
    /**
     * 后移位项
     */
    private String backShift;
    /**
     * 发动机型号
     */
    private String engineModel;
    /**
     * 方向形式
     */
    private String directionForm;
    /**
     * 发动机功率
     */
    private String enginePower;
    /**
     * 刹车形式
     */
    private String brakingForm;
    /**
     * 轮胎型号
     */
    private String tyreModel;
    /**
     * 变速箱
     */
    private String gearbox;
    /**
     * 行驶速度
     */
    private String speed;
    /**
     * 操作室
     */
    private String operatingRoom;
    /**
     * 轴距
     */
    private String wheelbase;
    /**
     * 实际/公告重量
     */
    private String weight;
    /**
     * 其他配置
     */
    private String otherConfiguration;
    /**
     * 选配
     */
    private String optional;
    private String img;
    /**
     * 发动机三泵
     */
    private String engineThreePumps;
    /**
     * 电机
     */
    private String motorThreePumps;
    /**
     * 中心回转
     */
    private String centerRotation;
    /**
     * 电机功率
     */
    private String motorPower;
    /**
     * 起升速度（副主钩）
     */
    private String liftingSpeed;
    /**
     * 大臂
     */
    private String bigArm;
    /**
     * 回转速度
     */
    private String swingSpeed;

}


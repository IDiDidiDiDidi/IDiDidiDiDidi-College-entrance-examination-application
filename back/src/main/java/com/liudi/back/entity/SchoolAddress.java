package com.liudi.back.entity;


import com.liudi.back.core.base.InfoEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 学校地址信息表
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
@Data
@TableName("school_address")
public class SchoolAddress extends InfoEntity {

    /**
     * 院校
     */
    private String schoolName;
    /**
     * 院校编码
     */
    private String schoolNo;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 县
     */
    private String county;
    /**
     * 区
     */
    private String district;
    /**
     * 地址编码
     */
    private String adcode;
    /**
     * 城市级别
     */
    private String cityLevel;
    /**
     * 国家
     */
    private String country;
    /**
     * 城市编码
     */
    private String cityCode;
    /**
     * 格式化地址
     */
    private String formattedAddress;
    /**
     * 经度
     */
    private String lat;
    /**
     * 纬度
     */
    private String lng;

}

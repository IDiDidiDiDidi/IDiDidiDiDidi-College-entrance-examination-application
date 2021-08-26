package com.liudi.back.entity;

import com.liudi.back.core.base.InfoEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
@Data
@TableName("sd_voluntary_report")
public class SdVoluntaryReport extends InfoEntity {

    /**
     * 专业
     */
    private String major;
    /**
     * 专业
     */
    private String majorNo;
    /**
     * 院校
     */
    private String schoolName;
    /**
     * 院校编码

     */
    private String schoolNo;
    /**
     * 计划数
     */
    private Integer plansNumber;
    /**
     * 投档计划数
     */
    private Integer pitchPlansNumber;
    /**
     * 投出数
     */
    private Integer castNumber;
    /**
     * 最低分
     */
    private Double lowestScore;
    /**
     * 最高分
     */
    private Double highestScore;
    /**
     * 最低位次
     */
    private Integer lowestPosition;
    /**
     * 最高位次
     */
    private Integer highestPosition;
    /**
     * year
     */
    private String year;
    /**
     * 投报批次
     */
    private Integer batch;
    /**
     * 层次
     */
    private String level;

}

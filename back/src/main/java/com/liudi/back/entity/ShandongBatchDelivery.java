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
 * @since 2021-08-03
 */
@Data
@TableName("shandong_batch_delivery")
public class ShandongBatchDelivery extends InfoEntity {

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
     * 院校
     */
    private String schoolNo;
    /**
     * 计划数
     */
    private String plansNumber;
    /**
     * 投档计划数
     */
    private String pitchPlansNumber;
    /**
     * 投出数
     */
    private String castNumber;
    /**
     * 最低分
     */
    private String lowestScore;
    /**
     * 最高分
     */
    private String highestScore;
    /**
     * 最低位次
     */
    private String lowestPosition;
    /**
     * 最高位次
     */
    private String highestPosition;
    /**
     * year
     */
    private String year;

}

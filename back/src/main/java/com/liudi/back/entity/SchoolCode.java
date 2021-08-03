package com.liudi.back.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.liudi.back.core.base.InfoEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * <p>
 * 技术经纪人
 * </p>
 *
 * @author LiuD
 * @since 2021-08-02
 */
@Data
@TableName("school_code")
public class SchoolCode extends InfoEntity {
    /**
     * 学校代码
     */
    @TableField("code_no")
    private String codeNo;
    /**
     * 学校名称
     */
    private String schoolName;
    /**
     * 备注
     */
    @TableField("notes")
    private String Notes;
}

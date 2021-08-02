package com.liudi.back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.liudi.back.core.base.BaseEntity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

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
public class SchoolCode extends BaseEntity {

    /**
     * 学校代码
     */
    @TableField("code_No")
    private String codeNo;
    /**
     * 学校名称
     */
    private String schoolName;
    /**
     * 备注
     */
    @TableField("Notes")
    private String Notes;

}

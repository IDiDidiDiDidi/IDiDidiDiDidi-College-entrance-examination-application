package com.liudi.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liudi.back.entity.SchoolCode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import com.liudi.back.vo.SchoolNameCodeVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 技术经纪人 Mapper 接口
 * </p>
 *
 * @author LiuD
 * @since 2021-08-02
 */
public interface SchoolCodeMapper extends BaseMapper<SchoolCode> {

    List<SchoolCode> findListPage(Page page, @Param("schoolCode") SchoolCode schoolCode);

    int add(@Param("schoolCode") SchoolCode schoolCode);

    String getNoBySchoolName(@Param("schoolName") String schoolName);

    /**
     * update school_code
     * @param schoolCode
     * @param schoolName
     * @return
     */
    Boolean updateSchoolCode(@Param("schoolCode") String schoolCode, @Param("schoolName") String schoolName);
}

package com.liudi.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liudi.back.dto.ShandongBatchDeliverySearchDto;
import com.liudi.back.entity.ShandongBatchDelivery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import com.liudi.back.vo.SchoolNameCodeVo;
import com.liudi.back.vo.SmartSearchVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况 Mapper 接口
 * </p>
 *
 * @author LiuD
 * @since 2021-08-03
 */
public interface ShandongBatchDeliveryMapper extends BaseMapper<ShandongBatchDelivery> {

    List<ShandongBatchDelivery> findListPage(Page page, @Param("searchDto") ShandongBatchDeliverySearchDto searchDto);

    List<SmartSearchVo> smartSearch(Page page, @Param("searchDto") ShandongBatchDeliverySearchDto searchDto);

    /**
     * 求学校编码
     * @return 求学校编码
     */
    List<SchoolNameCodeVo> getSchoolCode();

    Boolean updateSDSchoolCode(@Param("schoolCode") String schoolCode, @Param("schoolName") String schoolName);
}

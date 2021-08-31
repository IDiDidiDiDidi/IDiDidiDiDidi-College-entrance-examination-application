package com.liudi.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liudi.back.dto.SdVoluntaryReportDto;
import com.liudi.back.dto.SearchDto;
import com.liudi.back.entity.SdVoluntaryReport;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import com.liudi.back.vo.SchoolAddressVo;
import com.liudi.back.vo.SdVoluntaryReportVo;
import com.liudi.back.vo.SmartSearchVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况 Mapper 接口
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
public interface SdVoluntaryReportMapper extends BaseMapper<SdVoluntaryReport> {

    List<SdVoluntaryReport> findListPage(Page page, @Param("sdVoluntaryReport") SdVoluntaryReport sdVoluntaryReport);

    /**
     * 所有学校的name + code
     *
     * @return
     */
    List<SdVoluntaryReportVo> groupBySchoolName();

    List<SmartSearchVo> smartSearch(Page page, @Param("dto") SearchDto dto);

    /**
     * 获取企业详情
     * @param id the sd_voluntary_report base_id
     * @return
     */
    List<SdVoluntaryReport> getDetail(@Param("id") String id);
}

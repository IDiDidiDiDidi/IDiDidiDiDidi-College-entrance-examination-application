package com.liudi.back.service;

import com.liudi.back.dto.SchoolQueryDto;
import com.liudi.back.dto.SearchDto;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudi.back.entity.SdVoluntaryReport;
import com.liudi.back.vo.MinMaxVo;
import com.liudi.back.vo.SchoolVo;
import com.liudi.back.vo.SmartSearchVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况 服务类
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
public interface ISdVoluntaryReportService {

    List<SmartSearchVo> findListPage(Page page, SearchDto sdVoluntaryReport);

    Map<String, List<SdVoluntaryReport>> getById(String id);

    /**
     * 学校列表
     * @param page
     * @param dto schoolName
     * @return
     */
    List<SchoolVo> findSchoolListPage(Page<SdVoluntaryReport> page, SchoolQueryDto dto);

    List<MinMaxVo> getScoreMinMax(String id);

    List<MinMaxVo> getPositionMinMax(String id);
}

package com.liudi.back.service.impl;

import com.liudi.back.core.base.StringUtil;
import com.liudi.back.dto.SearchDto;
import com.liudi.back.entity.SdVoluntaryReport;
import com.liudi.back.mapper.SdVoluntaryReportMapper;
import com.liudi.back.service.ISdVoluntaryReportService;
import com.liudi.back.utils.BeanCopyUtil;
import com.liudi.back.vo.SmartSearchVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况 服务实现类
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
@Service
public class SdVoluntaryReportServiceImpl implements ISdVoluntaryReportService {
    @Autowired
    private SdVoluntaryReportMapper sdVoluntaryReportMapper;

    @Override
    public List<SmartSearchVo> findListPage(Page page, SearchDto dto) {
        SdVoluntaryReport sdVoluntaryReport = BeanCopyUtil.convertBean(dto, SdVoluntaryReport.class);
        if (dto != null || !StringUtil.isEmpty(dto.getProvinceId())) {
            if (!StringUtil.isEmpty(dto.getCityId())) {
                dto.setAreaBaseId(dto.getCityId());
            } else {
                dto.setAreaBaseId(dto.getProvinceId());
            }
        }


        List<SmartSearchVo> list = sdVoluntaryReportMapper.smartSearch(page, dto);

        return list;
    }


}

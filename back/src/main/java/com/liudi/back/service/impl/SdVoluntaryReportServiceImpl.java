package com.liudi.back.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liudi.back.core.base.StringUtil;
import com.liudi.back.dto.SchoolQueryDto;
import com.liudi.back.dto.SearchDto;
import com.liudi.back.entity.SdVoluntaryReport;
import com.liudi.back.mapper.SdVoluntaryReportMapper;
import com.liudi.back.service.ISdVoluntaryReportService;
import com.liudi.back.utils.BeanCopyUtil;
import com.liudi.back.vo.MinMaxVo;
import com.liudi.back.vo.SchoolVo;
import com.liudi.back.vo.SmartSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

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
@Slf4j
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
        return sdVoluntaryReportMapper.smartSearch(page, dto);
    }

    @Override
    public Map<String, List<SdVoluntaryReport>> getById(String id) {

        List<Object> list = new ArrayList<>();
        List<SdVoluntaryReport> detail = sdVoluntaryReportMapper.getDetail(id);
        Map<String, List<SdVoluntaryReport>> collect = detail.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(SdVoluntaryReport::getYear));
        log.info("========= collect : {}", collect);
        for (Map.Entry<String, List<SdVoluntaryReport>> stringListEntry : collect.entrySet()) {
            String year = stringListEntry.getKey();
            List<SdVoluntaryReport> value = stringListEntry.getValue();
            Map<String, Object> detailMap = new HashMap<>();
            detailMap.put("year", year);
            detailMap.put("value", value);
            list.add(detailMap);
        }
//        log.info("========= list: {}", JSONObject.parseObject(list.toString()));
        return collect;
    }

    @Override
    public List<SchoolVo> findSchoolListPage(Page<SdVoluntaryReport> page, SchoolQueryDto dto) {
        List<SchoolVo> schoolVoList = sdVoluntaryReportMapper.findSchoolListPage(page, dto);
        return schoolVoList;
    }

    @Override
    public List<MinMaxVo> getScoreMinMax(String id) {
        return sdVoluntaryReportMapper.getScoreMinMax(id);
    }

    @Override
    public List<MinMaxVo> getPositionMinMax(String id) {
        return sdVoluntaryReportMapper.getPositionMinMax(id);
    }


}

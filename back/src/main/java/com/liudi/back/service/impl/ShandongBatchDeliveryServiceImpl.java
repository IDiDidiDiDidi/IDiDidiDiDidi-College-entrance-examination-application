package com.liudi.back.service.impl;

import com.liudi.back.dto.ShandongBatchDeliverySearchDto;
import com.liudi.back.entity.SdVoluntaryReport;
import com.liudi.back.entity.ShandongBatchDelivery;
import com.liudi.back.mapper.SchoolCodeMapper;
import com.liudi.back.mapper.SdVoluntaryReportMapper;
import com.liudi.back.mapper.ShandongBatchDeliveryMapper;
import com.liudi.back.service.IShandongBatchDeliveryService;
import com.liudi.back.utils.Message;
import com.liudi.back.vo.SmartSearchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
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
 * @since 2021-08-03
 */
@Service
@Slf4j
public class ShandongBatchDeliveryServiceImpl implements IShandongBatchDeliveryService {
    @Autowired
    private ShandongBatchDeliveryMapper shandongBatchDeliveryMapper;

    @Autowired
    private SchoolCodeMapper schoolCodeMapper;

    @Autowired
    private SdVoluntaryReportMapper sdVoluntaryReportMapper;

    @Autowired
    ThreadService threadService;

    @Override
    public List<SmartSearchVo> findListPage(Page page, ShandongBatchDeliverySearchDto searchDto) {

        // 1. - 输入成绩， 给出最低录取分数上下50分的所有学校 + 专业
        // 2. - 输入排名，给出上下5万名的所有学校 + 专业
        List<SmartSearchVo> list = shandongBatchDeliveryMapper.smartSearch(page, searchDto);
        return list;
    }

    @Async
    @Override
    public Message insert(List<SdVoluntaryReport> shandongBatchDeliveries, int year, Integer batch) {
        if (shandongBatchDeliveries == null || shandongBatchDeliveries.isEmpty()) {
            return Message.fail("the excel is null");
        }
        threadService.insertSdVoluntaryReportMapper(shandongBatchDeliveries, year, batch);
        log.info("=========== 正在进行后台导入");
        return Message.success("正在进行后台导入");
    }

    @Override
    public ShandongBatchDelivery getById(String id) {
        return shandongBatchDeliveryMapper.selectById(id);
    }

}

package com.liudi.back.service.impl;

import com.liudi.back.entity.SdVoluntaryReport;
import com.liudi.back.mapper.SdVoluntaryReportMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ThreadService {

    @Autowired
    private SdVoluntaryReportMapper sdVoluntaryReportMapper;

    @Async("taskQueueExecutor")
    public void insertSdVoluntaryReportMapper(List<SdVoluntaryReport> shandongBatchDeliveries, int year, Integer batch) {
        try {
            log.info("========== 休眠2 秒中===========");
            Thread.sleep(2000);

            shandongBatchDeliveries = shandongBatchDeliveries.parallelStream().map(e -> {
                log.info("========= 线程 - {}", Thread.currentThread().getName());
                // 1.add school_no
                e.setSchoolNo(e.getSchoolName().substring(0, 4));
                e.setMajorNo(e.getMajor().substring(0, 2));
                e.setYear(year + "");
                e.setBatch(batch);
                e.setCreator("LD");
                sdVoluntaryReportMapper.insert(e);
                return e;
            }).collect(Collectors.toList());

            log.info("========= 更新完成了 =========");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

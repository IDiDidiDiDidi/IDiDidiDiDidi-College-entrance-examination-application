package com.liudi.back.service;

import com.liudi.back.entity.SdVoluntaryReport;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况 服务类
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
public interface ISdVoluntaryReportService {

 List<SdVoluntaryReport> findListPage(Page page ,SdVoluntaryReport sdVoluntaryReport);

}

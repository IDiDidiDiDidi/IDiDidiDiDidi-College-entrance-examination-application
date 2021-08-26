package com.liudi.back.service;

import com.liudi.back.entity.SchoolAddress;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudi.back.vo.SdVoluntaryReportVo;

import java.util.List;

/**
 * <p>
 * 学校地址信息表 服务类
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
public interface ISchoolAddressService {

    List<SchoolAddress> findListPage(Page page, SchoolAddress schoolAddress);

    void insertByBaidu(List<SdVoluntaryReportVo> vos);
}

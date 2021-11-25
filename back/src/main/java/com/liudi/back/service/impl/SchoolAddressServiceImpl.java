package com.liudi.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liudi.back.entity.*;
import com.liudi.back.mapper.SchoolAddressMapper;
import com.liudi.back.mapper.SdVoluntaryReportMapper;
import com.liudi.back.service.ISchoolAddressService;
import com.liudi.back.utils.BaiduMapUtils;
import com.liudi.back.vo.SdVoluntaryReportVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 学校地址信息表 服务实现类
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
@Service
@Slf4j
public class SchoolAddressServiceImpl implements ISchoolAddressService {
    @Autowired
    private SchoolAddressMapper schoolAddressMapper;

    @Autowired
    private SdVoluntaryReportMapper sdVoluntaryReportMapper;

    @Override
    public List<SchoolAddress> findListPage(Page page, SchoolAddress schoolAddress) {
        return schoolAddressMapper.findListPage(page, schoolAddress);
    }

    /**
     * 将学校地址存入库中
     * @param vos
     */
//    @Async("taskQueueExecutor")
    public void insertByBaidu(List<SdVoluntaryReportVo> vos) {
        vos.stream().filter(Objects::nonNull).map(e -> {
            log.info("========= 线程 - {}", Thread.currentThread().getName());
            String schoolName = e.getSchoolName();
            String schoolNo = e.getSchoolNo();

            QueryWrapper<SchoolAddress>  queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("school_no", schoolNo);
            SchoolAddress selectOne = schoolAddressMapper.selectOne(queryWrapper);
            if (selectOne == null){
                BaiduMapLngLatBean baiduMapLngLatBean = BaiduMapUtils.addressTolongitudea(schoolName);
                Location location = baiduMapLngLatBean.getLocation();
                BaiduMapAddressBean baiduMapAddressBean = BaiduMapUtils.longitudeToAddress(location.getLat(), location.getLng());
                AddressComponent addressComponent = baiduMapAddressBean.getAddressComponent();

                SchoolAddress schoolAddress = new SchoolAddress();
                schoolAddress.setSchoolNo(schoolNo);
                schoolAddress.setSchoolName(schoolName);
                schoolAddress.setProvince(addressComponent.getProvince());
                schoolAddress.setCity(addressComponent.getCity());
                schoolAddress.setDistrict(addressComponent.getDistrict());
                schoolAddress.setAdcode(addressComponent.getAdcode());
                schoolAddress.setCityCode(addressComponent.getCity_level().toString());
                schoolAddress.setCountry(addressComponent.getCountry());
                schoolAddress.setCityCode(baiduMapAddressBean.getCityCode().toString());
                schoolAddress.setFormattedAddress(baiduMapAddressBean.getFormatted_address());
                schoolAddress.setLat(location.getLat());
                schoolAddress.setLng(location.getLng());

                int insert = schoolAddressMapper.insert(schoolAddress);
            }
            return e;
        }).collect(Collectors.toList());
    }

}

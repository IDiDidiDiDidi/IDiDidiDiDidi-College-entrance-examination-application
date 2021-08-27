package com.liudi.back;

import com.alibaba.fastjson.JSON;
import com.liudi.back.entity.BaiduMapAddressBean;
import com.liudi.back.entity.BaiduMapLngLatBean;
import com.liudi.back.entity.Location;
import com.liudi.back.mapper.SdVoluntaryReportMapper;
import com.liudi.back.service.ISchoolAddressService;
import com.liudi.back.utils.BaiduMapUtils;
import com.liudi.back.vo.SdVoluntaryReportVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BaiduMapTest {

    @Autowired
    private SdVoluntaryReportMapper sdVoluntaryReportMapper;

    @Autowired
    private ISchoolAddressService schoolAddressService;

    @Test
    public void test() {
        BaiduMapLngLatBean lngLatBean = BaiduMapUtils.addressTolongitudea("西北民族大学榆中校区");
        Location location = lngLatBean.getLocation();
        BaiduMapAddressBean baiduMapAddressBean = BaiduMapUtils.longitudeToAddress(location.getLat(), location.getLng());
        System.out.println(JSON.toJSONString(baiduMapAddressBean));
    }

    @Test
    void insertToSchoolAddress() {
        List<SdVoluntaryReportVo> vos = sdVoluntaryReportMapper.groupBySchoolName();
        schoolAddressService.insertByBaidu(vos);
    }
}

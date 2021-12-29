package com.liudi.back;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liudi.back.core.base.StringUtil;
import com.liudi.back.entity.SchoolCode;
import com.liudi.back.entity.SdVoluntaryReport;
import com.liudi.back.entity.User;
import com.liudi.back.mapper.SchoolCodeMapper;
import com.liudi.back.mapper.SdVoluntaryReportMapper;
import com.liudi.back.mapper.ShandongBatchDeliveryMapper;
import com.liudi.back.mapper.UserMapper;
import com.liudi.back.vo.SchoolNameCodeVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class SampleTest {

    @Autowired
    private SchoolCodeMapper schoolCodeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShandongBatchDeliveryMapper shandongBatchDeliveryMapper;

    @Autowired
    private SdVoluntaryReportMapper sdVoluntaryReportMapper;

//    @Test
    public void testUserSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

//    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));

        List<SchoolCode> userList = schoolCodeMapper.selectList(null);
        userList.forEach(System.out::println);
    }


    //    @Test
    void updateSDSchoolCode() {
        List<SchoolNameCodeVo> vos = shandongBatchDeliveryMapper.getSchoolCode();
        log.info("=========== vos: {}", JSON.toJSONString(vos));
        int i = 0;
        for (SchoolNameCodeVo vo : vos) {
            if (vo != null && !StringUtil.isEmpty(vo.getSchoolCode()) && !StringUtil.isEmpty(vo.getSchoolName())) {
                Boolean b = shandongBatchDeliveryMapper.updateSDSchoolCode(vo.getSchoolCode(), vo.getSchoolName());
                System.out.println("=================" + i++);
            }
        }
    }


//    @Test
    void updateSchoolCode() {
        List<SchoolNameCodeVo> vos = shandongBatchDeliveryMapper.getSchoolCode();
        log.info("=========== vos: {}", JSON.toJSONString(vos));
        int i = 0;
        for (SchoolNameCodeVo vo : vos) {
            if (vo != null && !StringUtil.isEmpty(vo.getSchoolCode()) && !StringUtil.isEmpty(vo.getSchoolName())) {
                Boolean aBoolean = schoolCodeMapper.updateSchoolCode(vo.getSchoolCode(), vo.getSchoolName());

                if (aBoolean) System.out.println("=================" + i++);
            }
        }
    }

//    @Test
//    void testDate() {
//        QueryWrapper<SdVoluntaryReport> queryWrapper = new QueryWrapper<>();
//        List<String> list = new ArrayList<>();
//        list.add("00002ff95121508bb6168372006eab6a");
//        list.add("00e38523cb8ae0727f97ef9bb346b318");
//        list.add("00f34e6ed549a485f8bec86ad9695682");
//        list.add("02613b44243b0248eb23b6da4dce8444");
//        queryWrapper.in("base_id", list);
//        List<SdVoluntaryReport> sdVoluntaryReports = sdVoluntaryReportMapper.selectList(queryWrapper);
//
//        String s = JSONObject.toJSONString(sdVoluntaryReports);
//        System.out.println("================== : {}"+ s);
//
//
//        List<Long> collect = sdVoluntaryReports.stream().map(SdVoluntaryReport::getBaseCreateTime).map(e -> e.getTime()).collect(Collectors.toList());
//
//        String collectStr = JSONObject.toJSONString(collect);
//        System.out.println("================== : {}"+ collectStr);
//    }


}

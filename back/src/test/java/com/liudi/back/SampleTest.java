package com.liudi.back;

import com.alibaba.fastjson.JSON;
import com.liudi.back.core.base.StringUtil;
import com.liudi.back.entity.SchoolCode;
import com.liudi.back.entity.User;
import com.liudi.back.mapper.SchoolCodeMapper;
import com.liudi.back.mapper.ShandongBatchDeliveryMapper;
import com.liudi.back.mapper.UserMapper;
import com.liudi.back.vo.SchoolNameCodeVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SampleTest {

    @Autowired
    private SchoolCodeMapper schoolCodeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShandongBatchDeliveryMapper shandongBatchDeliveryMapper;

    @Test
    public void testUserSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
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


    @Test
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


}

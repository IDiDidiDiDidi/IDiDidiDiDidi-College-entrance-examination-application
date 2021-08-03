package com.liudi.back;

import com.liudi.back.entity.SchoolCode;
import com.liudi.back.entity.User;
import com.liudi.back.mapper.SchoolCodeMapper;
import com.liudi.back.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private SchoolCodeMapper schoolCodeMapper;

    @Autowired
    private UserMapper userMapper;

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
}

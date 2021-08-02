package com.liudi.back.service.impl;

import com.liudi.back.dto.SchoolCodeDto;
import com.liudi.back.entity.SchoolCode;
import com.liudi.back.mapper.SchoolCodeMapper;
import com.liudi.back.service.ISchoolCodeService;
import com.liudi.back.utils.BeanCopyUtil;
import com.liudi.back.utils.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 技术经纪人 服务实现类
 * </p>
 *
 * @author LiuD
 * @since 2021-08-02
 */
@Service("iSchoolCodeService")
public class SchoolCodeServiceImpl implements ISchoolCodeService {
    @Autowired
    private SchoolCodeMapper schoolCodeMapper;

    @Override
    public List<SchoolCode> findListPage(Page page, SchoolCode schoolCode) {
        return schoolCodeMapper.findListPage(page, schoolCode);
    }

    @Override
    public Message save(SchoolCodeDto schoolCodeDto) {
        SchoolCode schoolCode = BeanCopyUtil.convertBean(schoolCodeDto, SchoolCode.class);


        schoolCodeMapper.insert(schoolCode);
        return null;
    }

}

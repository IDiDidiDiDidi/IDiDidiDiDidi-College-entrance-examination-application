package com.liudi.back.service.impl;

import com.liudi.back.dto.ShandongBatchDeliverySearchDto;
import com.liudi.back.entity.ShandongBatchDelivery;
import com.liudi.back.mapper.SchoolCodeMapper;
import com.liudi.back.mapper.ShandongBatchDeliveryMapper;
import com.liudi.back.service.IShandongBatchDeliveryService;
import com.liudi.back.utils.BaiduMapUtils;
import com.liudi.back.utils.Message;
import com.liudi.back.vo.SmartSearchVo;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public List<SmartSearchVo> findListPage(Page page, ShandongBatchDeliverySearchDto searchDto) {

        // 1. - 输入成绩， 给出最低录取分数上下50分的所有学校 + 专业
        // 2. - 输入排名，给出上下5万名的所有学校 + 专业
        List<SmartSearchVo> list = shandongBatchDeliveryMapper.smartSearch(page, searchDto);

        return list;

//        return shandongBatchDeliveryMapper.findListPage(page, searchDto);
    }

    @Override
    public Message insert(List<ShandongBatchDelivery> shandongBatchDeliveries) {
        if (shandongBatchDeliveries == null || shandongBatchDeliveries.isEmpty()) {
            return Message.fail("the excel is null");
        }
        shandongBatchDeliveries.forEach(e -> {
            // 1.add school_no
            String schoolName = e.getSchoolName().substring(4);
            String codeNo = schoolCodeMapper.getNoBySchoolName(schoolName);

            shandongBatchDeliveryMapper.insert(e);
        });

        return Message.success();
    }

    @Override
    public ShandongBatchDelivery getById(String id) {
        return shandongBatchDeliveryMapper.selectById(id);
    }

    @Override
    public Message updateMap() {
        // 所有的学校，

//        BaiduMapUtils.addressTolongitudea();



        return null;
    }

    public static void main(String[] args) {
        String name = "H422山东大学威海分校";

        System.out.println(name.substring(4));
    }

}

package com.liudi.back.service.impl;

import com.liudi.back.entity.ShandongBatchDelivery;
import com.liudi.back.mapper.ShandongBatchDeliveryMapper;
import com.liudi.back.service.IShandongBatchDeliveryService;
import com.liudi.back.utils.Message;
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
public class ShandongBatchDeliveryServiceImpl implements IShandongBatchDeliveryService {
    @Autowired
    private ShandongBatchDeliveryMapper shandongBatchDeliveryMapper;

    @Override
    public List<ShandongBatchDelivery> findListPage(Page page, ShandongBatchDelivery shandongBatchDelivery) {
        return shandongBatchDeliveryMapper.findListPage(page, shandongBatchDelivery);
    }

    @Override
    public Message insert(List<ShandongBatchDelivery> shandongBatchDeliveries) {
        if(shandongBatchDeliveries == null || shandongBatchDeliveries.isEmpty()) {
            return Message.fail("the excel is null");
        }
        shandongBatchDeliveries.forEach(e -> {
            shandongBatchDeliveryMapper.insert(e);
        });

        return Message.success();
    }

}

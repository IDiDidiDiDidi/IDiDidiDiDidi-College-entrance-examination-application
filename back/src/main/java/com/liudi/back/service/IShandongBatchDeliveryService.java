package com.liudi.back.service;

import com.liudi.back.entity.ShandongBatchDelivery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudi.back.utils.Message;

import java.util.List;

/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况 服务类
 * </p>
 *
 * @author LiuD
 * @since 2021-08-03
 */
public interface IShandongBatchDeliveryService {

    List<ShandongBatchDelivery> findListPage(Page page, ShandongBatchDelivery shandongBatchDelivery);

    Message insert(List<ShandongBatchDelivery> shandongBatchDeliveries);

    /**
     * get by id
     * @param id
     * @return
     */
    ShandongBatchDelivery getById(String id);
}

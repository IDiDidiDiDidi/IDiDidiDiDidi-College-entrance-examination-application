package com.liudi.back.service;

import com.liudi.back.dto.ShandongBatchDeliverySearchDto;
import com.liudi.back.entity.ShandongBatchDelivery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudi.back.utils.Message;
import com.liudi.back.vo.SmartSearchVo;

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

    /**
     * 输入成绩， 给出最低录取分数上下50分的所有学校
     * @param page
     * @param shandongBatchDelivery
     * @return
     */
    List<SmartSearchVo> findListPage(Page page, ShandongBatchDeliverySearchDto shandongBatchDelivery);

    Message insert(List<ShandongBatchDelivery> shandongBatchDeliveries);

    /**
     * get by id
     * @param id
     * @return
     */
    ShandongBatchDelivery getById(String id);

    /**
     * 更新地图
     * @return
     */
    Message updateMap();

}

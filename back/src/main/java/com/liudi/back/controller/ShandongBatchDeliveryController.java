package com.liudi.back.controller;

import com.liudi.back.core.base.WebController;
import com.liudi.back.dto.ShandongBatchDeliverySearchDto;
import com.liudi.back.utils.BeanCopyUtil;
import com.liudi.back.utils.Message;
import com.liudi.back.vo.SmartSearchVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudi.back.entity.ShandongBatchDelivery;
import com.liudi.back.dto.ShandongBatchDeliveryDto;
import com.liudi.back.service.IShandongBatchDeliveryService;

import java.util.List;


/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况 前端控制器
 * </p>
 *
 * @author LiuD
 * @since 2021-08-03
 */
@RestController
@RequestMapping("search")
@CrossOrigin
@Api(tags = "shandongBatchDelivery", description = "shandongBatchDelivery")
public class ShandongBatchDeliveryController extends WebController {
    protected final Logger logger = LoggerFactory.getLogger(ShandongBatchDeliveryController.class);

    @Autowired
    private IShandongBatchDeliveryService shandongBatchDeliveryService;


    @ApiOperation(value = "数据详情")
    @GetMapping("/{id}")
    public Message getShandongBatchDeliveryInfo(@PathVariable("id") String id) {
        try {
            ShandongBatchDelivery shandongBatchDelivery = shandongBatchDeliveryService.getById(id);
            return Message.success(shandongBatchDelivery);
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Message.fail(e.getMessage());
        }
    }

    @ApiOperation(value = "自定义查询列表-分页")
    @GetMapping("list")
    public Message findShandongBatchDeliveryListPage(ShandongBatchDeliverySearchDto searchDto) {
        try {
            Integer pageSize = searchDto.getPageSize();
            Integer pageNum = searchDto.getPageNum();
            Page<ShandongBatchDelivery> page = startPage(pageNum, pageSize);
            List<SmartSearchVo> list = shandongBatchDeliveryService.findListPage(page, searchDto);
            return Message.success(getPageResult(list, pageNum, pageSize, (int) page.getTotal()));
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Message.fail(e.getMessage());
        }
    }
}

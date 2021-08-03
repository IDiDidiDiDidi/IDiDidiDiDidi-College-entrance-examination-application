package com.liudi.back.controller;

import com.liudi.back.entity.ShandongBatchDelivery;
import com.liudi.back.service.IShandongBatchDeliveryService;
import com.liudi.back.utils.BeanCopyUtil;
import com.liudi.back.utils.ImportExcelUtil;
import com.liudi.back.utils.Message;
import com.liudi.back.vo.ShandongBatchDeliveryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("schoolCode")
@Api(tags = "导入 山东生源地各高校历年录取分数线 Excel数据", description = "schoolCode")
public class importExcelController {
    protected final Logger logger = LoggerFactory.getLogger(importExcelController.class);

    @Autowired
    private IShandongBatchDeliveryService shandongBatchDeliveryService;

    @ApiOperation(value = "导入 ")
    @PostMapping("importEx")
    public Message importEx(@RequestPart(value = "file") MultipartFile file) {
        try {
            List<Map<String, Object>> maps = ImportExcelUtil.importExcelOneSheet(file, ShandongBatchDeliveryVo.class, false);

            List<ShandongBatchDelivery> shandongBatchDeliveries = BeanCopyUtil.convertList(maps, ShandongBatchDelivery.class);
            return shandongBatchDeliveryService.insert(shandongBatchDeliveries);
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Message.fail(e.getMessage());
        }
    }

}

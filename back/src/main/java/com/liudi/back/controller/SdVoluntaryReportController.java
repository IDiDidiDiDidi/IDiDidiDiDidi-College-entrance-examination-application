package com.liudi.back.controller;

import com.liudi.back.core.base.WebController;
import com.liudi.back.dto.SchoolQueryDto;
import com.liudi.back.dto.SearchDto;
import com.liudi.back.utils.BeanCopyUtil;
import com.liudi.back.utils.Message;
import com.liudi.back.vo.SchoolVo;
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

import com.liudi.back.entity.SdVoluntaryReport;
import com.liudi.back.dto.SdVoluntaryReportDto;
import com.liudi.back.service.ISdVoluntaryReportService;

import java.util.List;


/**
 * <p>
 * 山东省普通类常规批第一次志愿投档情况 前端控制器
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
@RestController
@RequestMapping("search")
@Api(tags = "sdVoluntaryReport", description = "sdVoluntaryReport")
public class SdVoluntaryReportController extends WebController {
    protected final Logger logger = LoggerFactory.getLogger(SdVoluntaryReportController.class);

    @Autowired
    private ISdVoluntaryReportService sdVoluntaryReportService;


    @ApiOperation(value = "自定义查询列表-分页")
    @GetMapping("list")
    public Message findSdVoluntaryReportListPage(SearchDto dto) {
        try {
            Integer pageSize = dto.getPageSize();
            Integer pageNum = dto.getPageNum();
            Page<SdVoluntaryReport> page = startPage(pageNum, pageSize);
            List<SmartSearchVo> listPage = sdVoluntaryReportService.findListPage(page, dto);
            return Message.success(getPageResult(listPage, pageNum, pageSize, (int) page.getTotal()));
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询学校 列表")
    @GetMapping("school")
    public Message findSdVoluntaryReportListPage(SchoolQueryDto dto) {
        try {
            Integer pageSize = dto.getPageSize();
            Integer pageNum = dto.getPageNum();
            Page<SdVoluntaryReport> page = startPage(pageNum, pageSize);
            List<SchoolVo> listPage = sdVoluntaryReportService.findSchoolListPage(page, dto);
            return Message.success(getPageResult(listPage, pageNum, pageSize, (int) page.getTotal()));
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
    }

    @ApiOperation(value = "数据详情")
    @GetMapping("/{id}")
    public Message getSdVoluntaryReportInfo(@PathVariable("id") String id) {
        try {
            List<SdVoluntaryReport> sdVoluntaryReport = sdVoluntaryReportService.getById(id);
            return Success(sdVoluntaryReport);
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
    }
//
//    @ApiOperation(value = "根据id更新")
//    @PutMapping()
//    public Message updatesdVoluntaryReport(@RequestBody SdVoluntaryReportDto sdVoluntaryReportDto) {
//        try {
//            SdVoluntaryReport sdVoluntaryReport = BeanCopyUtil.convertBean(sdVoluntaryReportDto, SdVoluntaryReport.class);
//            sdVoluntaryReportService.updateById(sdVoluntaryReport);
//            return Success();
//        } catch (Exception e) {
//            logger.error("更新异常：===》" + e);
//            return Error(e.getMessage());
//        }
//    }
//
//    @ApiOperation(value = "根据baseId逻辑删除")
//    @DeleteMapping("/{id}")
//    public Message updateByIsDelete(@PathVariable("id") String id) {
//        try {
//            List<String> strings = StringUtil.splitStr(id, ",");
//            return Success(sdVoluntaryReportService.removeByIds(strings));
//        } catch (Exception e) {
//            logger.error("删除异常：===》" + e);
//            return Error(e.getMessage());
//        }
//    }

}

package com.liudi.back.controller;

import com.liudi.back.core.base.WebController;
import com.liudi.back.dto.SchoolQueryDto;
import com.liudi.back.dto.SearchDto;
import com.liudi.back.utils.BeanCopyUtil;
import com.liudi.back.utils.Message;
import com.liudi.back.vo.MinMaxVo;
import com.liudi.back.vo.SchoolVo;
import com.liudi.back.vo.SmartSearchVo;
import org.apache.ibatis.annotations.Mapper;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @ApiOperation(value = "学校数据详情")
    @GetMapping("/{id}")
    public Message getSdVoluntaryReportInfo(@PathVariable("id") String id) {
        try {
            // 按照年分，一年一个图一个表： 20、21 两年就是弄两个card 每个card中放一个图一个表

            Map<String, Object> map = new HashMap<>();
            Map<String, List<SdVoluntaryReport>> sdVoluntaryReportList = sdVoluntaryReportService.getById(id);
            // 该学校的这些年来录取专业的最高分最低分
            List<MinMaxVo> scoreMinMaxList = sdVoluntaryReportService.getScoreMinMax(id);
            // 该学校的这些年来录取专业的最高排名最排名
            List<MinMaxVo> positionMinMaxList =sdVoluntaryReportService.getPositionMinMax(id);
            map.put("sdVoluntaryReportList", sdVoluntaryReportList);
            map.put("positionMinMaxList", positionMinMaxList);
            map.put("scoreMinMaxList", scoreMinMaxList);
            // 该学校


            return Success(map);
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
    }

    //学校 - 专业 - 每年录取分数变化 + 排名变化
    @ApiOperation(value = "学校数据详情")
    @GetMapping("/{id}/{major}")
    public Message getMajorDetail(@PathVariable("id") String id, @PathVariable("major") String major) {
        try {

            Map<String, Object> map = new HashMap<>();
            // 该学校的这些年来录取专业的最高排名最排名
            return Success(map);
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
    }


}

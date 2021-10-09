package com.liudi.back.controller;

import com.liudi.back.core.base.StringUtil;
import com.liudi.back.core.base.WebController;
import com.liudi.back.utils.BeanCopyUtil;
import com.liudi.back.utils.Message;
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

import com.liudi.back.entity.Crane;
import com.liudi.back.dto.CraneDto;
import com.liudi.back.service.ICraneService;

import java.util.List;


/**
 * <p>
 * 吊车详细配置 前端控制器
 * </p>
 *
 * @author LiuD
 * @since 2021-10-09
 */
@RestController
@RequestMapping("crane")
@Api(tags = "吊车", description = "吊车详情")
public class CraneController extends WebController {
    protected final Logger logger = LoggerFactory.getLogger(CraneController.class);

    @Autowired
    private ICraneService craneService;

    @ApiOperation(value = "保存")
    @PostMapping("")
    public Message addCrane(@RequestBody CraneDto craneDto) {
        try {
            Crane crane = BeanCopyUtil.convertBean(craneDto, Crane.class);
            return Success(craneService.save(crane));
        } catch (Exception e) {
            logger.error("保存异常：===》" + e);
            return Error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询所有")
    @GetMapping()
    public Message getCraneList() {
        try {
            return Success(craneService.list());
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询列表-分页")
    @GetMapping("craneListPage")
    public Message craneListPage(CraneDto craneDto) {
        try {
            Integer pageSize = craneDto.getPageSize();
            Integer pageNum = craneDto.getPageNum();
            Page<Crane> page = startPage(pageNum, pageSize);
            QueryWrapper<Crane> wrapper = new QueryWrapper<Crane>();
            IPage<Crane> pageResult = craneService.page(page, wrapper);
            List<Crane> list = pageResult.getRecords();
            return Success(getPageResult(list, pageNum, pageSize, (int) pageResult.getTotal()));
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
    }

    @ApiOperation(value = "数据详情")
    @GetMapping("/{id}")
    public Message getCraneInfo(@PathVariable("id") String id) {
        try {
            Crane crane = craneService.getById(id);
            return Success(crane);
        } catch (Exception e) {
            logger.error("查询异常：===》" + e);
            return Error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据id更新")
    @PutMapping()
    public Message updatecrane(@RequestBody CraneDto craneDto) {
        try {
            Crane crane = BeanCopyUtil.convertBean(craneDto, Crane.class);
            craneService.updateById(crane);
            return Success();
        } catch (Exception e) {
            logger.error("更新异常：===》" + e);
            return Error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据baseId逻辑删除")
    @DeleteMapping("/{id}")
    public Message updateByIsDelete(@PathVariable("id") String id) {
        try {
            List<String> strings = StringUtil.splitStr(id, ",");
            return Success(craneService.removeByIds(strings));
        } catch (Exception e) {
            logger.error("删除异常：===》" + e);
            return Error(e.getMessage());
        }
    }

//    @ApiOperation(value = "自定义查询列表-分页")
//    @GetMapping("findCraneListPage")
//    @ApiIgnore
//    public Message findCraneListPage(CraneDto craneDto) {
//        try {
//            Integer pageSize = craneDto.getPageSize();
//            Integer pageNum = craneDto.getPageNum();
//            Page<Crane> page = startPage(pageNum, pageSize);
//            Crane crane = BeanCopyUtil.convertBean(craneDto, Crane.class);
//            List<Crane> list = craneService.findListPage(page, crane);
//            return Success(getPageResult(list, pageNum, pageSize, (int) page.getTotal()));
//        } catch (Exception e) {
//            logger.error("查询异常：===》" + e);
//            return Error(e.getMessage());
//        }
//    }
}

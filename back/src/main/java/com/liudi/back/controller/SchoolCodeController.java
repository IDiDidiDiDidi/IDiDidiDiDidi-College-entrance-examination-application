package com.liudi.back.controller;

import com.liudi.back.utils.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.liudi.back.dto.SchoolCodeDto;
import com.liudi.back.service.ISchoolCodeService;

import java.util.List;


/**
 * <p>
 * 技术经纪人 前端控制器
 * </p>
 *
 * @author LiuD
 * @since 2021-08-02
 */
@RestController
@RequestMapping("schoolCode")
@Api(tags = "学校代码", description = "schoolCode")
public class SchoolCodeController {
    protected final Logger logger = LoggerFactory.getLogger(SchoolCodeController.class);

    @Autowired
    private ISchoolCodeService iSchoolCodeService;

    @ApiOperation(value = "保存")
    @PostMapping("")
    public Message addSchoolCode(@RequestBody List<SchoolCodeDto> schoolCodeDtos) {
        try {
            return iSchoolCodeService.save(schoolCodeDtos);
        } catch (Exception e) {
            logger.error("保存异常：===》" + e);
            return Message.fail(e.getMessage());
        }
    }
//
//    @ApiOperation(value = "查询所有")
//    @GetMapping()
//    public Message getSchoolCodeList() {
//        try {
//            return Success(schoolCodeService.list());
//        } catch (Exception e) {
//            logger.error("查询异常：===》" + e);
//            return Error(e.getMessage());
//        }
//    }
//
//    @ApiOperation(value = "查询列表-分页")
//    @GetMapping("schoolCodeListPage")
//    public Message schoolCodeListPage(SchoolCodeDto schoolCodeDto) {
//        try {
//            Integer pageSize = schoolCodeDto.getPageSize();
//            Integer pageNum = schoolCodeDto.getPageNum();
//            Page<SchoolCode> page = startPage(pageNum, pageSize);
//            QueryWrapper<SchoolCode> wrapper = new QueryWrapper<SchoolCode>();
//            IPage<SchoolCode> pageResult = schoolCodeService.page(page, wrapper);
//            List<SchoolCode> list = pageResult.getRecords();
//            return Success(getPageResult(list, pageNum, pageSize, (int) pageResult.getTotal()));
//        } catch (Exception e) {
//            logger.error("查询异常：===》" + e);
//            return Error(e.getMessage());
//        }
//    }
//
//    @ApiOperation(value = "数据详情")
//    @GetMapping("/{id}")
//    public Message getSchoolCodeInfo(@PathVariable("id") String id) {
//        try {
//            SchoolCode schoolCode = schoolCodeService.getById(id);
//            return Success(schoolCode);
//        } catch (Exception e) {
//            logger.error("查询异常：===》" + e);
//            return Error(e.getMessage());
//        }
//    }
//
//    @ApiOperation(value = "根据id更新")
//    @PutMapping()
//    public Message updateschoolCode(@RequestBody SchoolCodeDto schoolCodeDto) {
//        try {
//            SchoolCode schoolCode = BeanCopyUtil.convertBean(schoolCodeDto, SchoolCode.class);
//            schoolCodeService.updateById(schoolCode);
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
//            return Success(schoolCodeService.removeByIds(strings));
//        } catch (Exception e) {
//            logger.error("删除异常：===》" + e);
//            return Error(e.getMessage());
//        }
//    }
//
//    @ApiOperation(value = "自定义查询列表-分页")
//    @GetMapping("findSchoolCodeListPage")
//    public Message findSchoolCodeListPage(SchoolCodeDto schoolCodeDto) {
//        try {
//            Integer pageSize = schoolCodeDto.getPageSize();
//            Integer pageNum = schoolCodeDto.getPageNum();
//            Page<SchoolCode> page = startPage(pageNum, pageSize);
//            SchoolCode schoolCode = BeanCopyUtil.convertBean(schoolCodeDto, SchoolCode.class);
//            List<SchoolCode> list = schoolCodeService.findListPage(page, schoolCode);
//            return Success(getPageResult(list, pageNum, pageSize, (int) page.getTotal()));
//        } catch (Exception e) {
//            logger.error("查询异常：===》" + e);
//            return Error(e.getMessage());
//        }
//    }
}

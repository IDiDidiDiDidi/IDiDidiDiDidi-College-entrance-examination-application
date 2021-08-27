package com.liudi.back.controller;

import com.liudi.back.core.base.WebController;
import com.liudi.back.dto.SysAreaDto;
import com.liudi.back.entity.SysArea;
import com.liudi.back.service.ISysAreaService;
import com.liudi.back.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("sysArea")
@Api(tags = "地域", description = "sysArea")
public class SysAreaController extends WebController {

    @Autowired
    private ISysAreaService sysAreaService;

    @ApiOperation(value = "省市区三级联动查询", response = SysArea.class, notes = "检索参数:{baseParentId为空查询省级}")
    @GetMapping("sysAreaLink")
    public Message getSysAreaLink(SysAreaDto sysAreaDto) {
        return sysAreaService.getSysAreaLink(sysAreaDto);
    }
}

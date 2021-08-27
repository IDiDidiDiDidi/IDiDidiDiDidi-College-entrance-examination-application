package com.liudi.back.service;

import com.liudi.back.dto.SysAreaDto;
import com.liudi.back.utils.Message;

public interface ISysAreaService {
    /**
     * 省市区三级联动查询
     * @param sysAreaDto
     * @return
     */
    Message getSysAreaLink(SysAreaDto sysAreaDto);
}

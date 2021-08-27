package com.liudi.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liudi.back.core.base.BaseSerivceImpl;
import com.liudi.back.core.base.StringUtil;
import com.liudi.back.dto.SysAreaDto;
import com.liudi.back.entity.SysArea;
import com.liudi.back.mapper.SysAreaMapper;
import com.liudi.back.service.ISysAreaService;
import com.liudi.back.utils.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysAreaServiceImpl extends BaseSerivceImpl<SysAreaMapper, SysArea> implements ISysAreaService {

    @Override
    public Message getSysAreaLink(SysAreaDto sysAreaDto) {
        try {
            String baseParentId = sysAreaDto.getBaseParentId();
            QueryWrapper<SysArea> wrapper = new QueryWrapper();
            ((QueryWrapper) wrapper.eq("area_Is_show", 1)).eq("is_delete", 0);
            if (StringUtil.isEmpty(baseParentId)) {
                wrapper.isNull("base_parent_id");
            } else {
                wrapper.eq("base_parent_id", baseParentId);
            }

            wrapper.orderByAsc("sort");

            return Message.success(this.list(wrapper));
        } catch (Exception var4) {
            log.error("getSysAreaLink 查询异常:" + var4);
            return Message.fail(var4.getMessage());
        }
    }
}

package com.liudi.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

import com.liudi.back.entity.SysArea;
import org.apache.ibatis.annotations.Param;

public interface SysAreaMapper extends BaseMapper<SysArea> {
    int updateByIsDelete(@Param("baseIds") List<String> baseIds);

    List<SysArea> findListPage(Page page, @Param("sysArea") SysArea sysArea);
}

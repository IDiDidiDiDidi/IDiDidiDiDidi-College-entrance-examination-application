package com.liudi.back.mapper;

import com.liudi.back.entity.SchoolCode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

import com.liudi.back.utils.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 技术经纪人 Mapper 接口
 * </p>
 *
 * @author LiuD
 * @since 2021-08-02
 */
@Mapper
public interface SchoolCodeMapper extends SuperMapper<SchoolCode> {

 List<SchoolCode> findListPage(Page page ,@Param("schoolCode")SchoolCode schoolCode);
}

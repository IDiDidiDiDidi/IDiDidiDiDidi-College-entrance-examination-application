package com.liudi.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liudi.back.entity.SchoolAddress;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 学校地址信息表 Mapper 接口
 * </p>
 *
 * @author LiuD
 * @since 2021-08-26
 */
public interface SchoolAddressMapper extends BaseMapper<SchoolAddress> {

 List<SchoolAddress> findListPage(Page page ,@Param("schoolAddress")SchoolAddress schoolAddress);
}

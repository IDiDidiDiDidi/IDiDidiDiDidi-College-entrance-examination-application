package com.liudi.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liudi.back.entity.Crane;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import com.liudi.back.vo.CraneVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 吊车详细配置 Mapper 接口
 * </p>
 *
 * @author LiuD
 * @since 2021-10-09
 */
@Mapper
public interface CraneMapper extends BaseMapper<Crane> {

    List<Crane> findListPage(Page page, @Param("crane") Crane crane);

//    List<String> getByTonnage(@Param("t") String t);

    List<CraneVo> getByTonnage(@Param("t") String t);
}

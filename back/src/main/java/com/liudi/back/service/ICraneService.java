package com.liudi.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liudi.back.entity.Crane;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudi.back.vo.CraneVo;

import java.util.List;

/**
 * <p>
 * 吊车详细配置 服务类
 * </p>
 *
 * @author LiuD
 * @since 2021-10-09
 */
public interface ICraneService extends IService<Crane> {

    List<Crane> findListPage(Page page, Crane crane);

    /**
     * 获取全部的吨位分类
     * @return
     */
    List<CraneVo> getByTonnage(String t);

    /**
     * 获取 吊车详情
     * @param id
     * @return
     */
    Crane getDetail(String id);

    /**
     * 获取该车所有照片信息
     * @param id
     * @return
     */
    List<String> getCraneImgList(String id);
}

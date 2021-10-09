package com.liudi.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liudi.back.entity.Crane;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

 List<Crane> findListPage(Page page ,Crane crane);

}

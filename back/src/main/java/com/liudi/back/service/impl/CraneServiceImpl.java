package com.liudi.back.service.impl;

import com.liudi.back.core.base.BaseSerivceImpl;
import com.liudi.back.entity.Crane;
import com.liudi.back.entity.SysArea;
import com.liudi.back.mapper.CraneMapper;
import com.liudi.back.mapper.SysAreaMapper;
import com.liudi.back.service.ICraneService;
import com.liudi.back.vo.CraneVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 吊车详细配置 服务实现类
 * </p>
 *
 * @author LiuD
 * @since 2021-10-09
 */
@Service
public class CraneServiceImpl extends BaseSerivceImpl<CraneMapper, Crane> implements ICraneService {

      @Autowired
      private CraneMapper craneMapper;

      @Override
      public List<Crane> findListPage(Page page ,Crane crane){
           return craneMapper.findListPage(page,crane);
      }

      @Override
      public List<CraneVo> getByTonnage(String t) {
            return craneMapper.getByTonnage(t);
      }

      @Override
      public Crane getDetail(String id) {
            Crane crane = super.getById(id);
            return crane;
      }

}

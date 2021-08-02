package com.liudi.back.service;

import com.liudi.back.dto.SchoolCodeDto;
import com.liudi.back.entity.SchoolCode;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liudi.back.utils.Message;

import java.util.List;

/**
 * <p>
 * 技术经纪人 服务类
 * </p>
 *
 * @author LiuD
 * @since 2021-08-02
 */
public interface ISchoolCodeService {

    List<SchoolCode> findListPage(Page page, SchoolCode schoolCode);

    /**
     * 保存
     * @param schoolCodeDto
     * @return
     */
    Message save(SchoolCodeDto schoolCodeDto);
}

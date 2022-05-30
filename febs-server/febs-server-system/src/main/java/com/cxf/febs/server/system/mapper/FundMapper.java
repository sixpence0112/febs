package com.cxf.febs.server.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxf.febs.server.system.entity.Fund;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 基金表 Mapper
 *
 * @author sixpence
 * @date 2021-10-15 17:20:13
 */
public interface FundMapper extends BaseMapper<Fund> {

    IPage<Fund> findFundPage(Page page, @Param("fund") Fund fund);
}

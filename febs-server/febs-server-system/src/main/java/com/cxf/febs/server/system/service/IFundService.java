package com.cxf.febs.server.system.service;

import com.cxf.febs.server.system.entity.Fund;

import com.cxf.febs.common.core.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 基金表 Service接口
 *
 * @author sixpence
 * @date 2021-10-15 17:20:13
 */
public interface IFundService extends IService<Fund> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param fund fund
     * @return IPage<Fund>
     */
    IPage<Fund> findFunds(QueryRequest request, Fund fund);

    /**
     * 查询（所有）
     *
     * @param fund fund
     * @return List<Fund>
     */
    List<Fund> findFunds(Fund fund);

    /**
     * 新增
     *
     * @param fund fund
     */
    void createFund(Fund fund);

    /**
     * 修改
     *
     * @param fund fund
     */
    void updateFund(Fund fund);

    /**
     * 删除
     *
     * @param fund fund
     */
    void deleteFund(Fund fund);
}

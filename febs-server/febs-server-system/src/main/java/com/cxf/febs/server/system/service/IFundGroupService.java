package com.cxf.febs.server.system.service;

import com.cxf.febs.server.system.entity.FundGroup;

import com.cxf.febs.common.core.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 基金-基金分组关连表 Service接口
 *
 * @author sixpence
 * @date 2021-10-18 15:46:22
 */
public interface IFundGroupService extends IService<FundGroup> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param fundGroup fundGroup
     * @return IPage<FundGroup>
     */
    IPage<FundGroup> findFundGroups(QueryRequest request, FundGroup fundGroup);

    /**
     * 查询（所有）
     *
     * @param fundGroup fundGroup
     * @return List<FundGroup>
     */
    List<FundGroup> findFundGroups(FundGroup fundGroup);

    /**
     * 新增
     *
     * @param fundGroup fundGroup
     */
    void createFundGroup(FundGroup fundGroup);

    /**
     * 修改
     *
     * @param fundGroup fundGroup
     */
    void updateFundGroup(FundGroup fundGroup);

    /**
     * 删除
     *
     * @param fundGroup fundGroup
     */
    void deleteFundGroup(FundGroup fundGroup);
}

package com.cxf.febs.server.system.service;

import com.cxf.febs.server.system.entity.PurchaseRecord;

import com.cxf.febs.common.core.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 购买记录表 Service接口
 *
 * @author sixpence
 * @date 2021-10-18 09:54:45
 */
public interface IPurchaseRecordService extends IService<PurchaseRecord> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseRecord purchaseRecord
     * @return IPage<PurchaseRecord>
     */
    IPage<PurchaseRecord> findPurchaseRecords(QueryRequest request, PurchaseRecord purchaseRecord);

    /**
     * 查询（所有）
     *
     * @param purchaseRecord purchaseRecord
     * @return List<PurchaseRecord>
     */
    List<PurchaseRecord> findPurchaseRecords(PurchaseRecord purchaseRecord);

    /**
     * 新增
     *
     * @param purchaseRecord purchaseRecord
     */
    void createPurchaseRecord(PurchaseRecord purchaseRecord);

    /**
     * 修改
     *
     * @param purchaseRecord purchaseRecord
     */
    void updatePurchaseRecord(PurchaseRecord purchaseRecord);

    /**
     * 删除
     *
     * @param purchaseRecord purchaseRecord
     */
    void deletePurchaseRecord(PurchaseRecord purchaseRecord);
}

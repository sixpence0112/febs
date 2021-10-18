package com.cxf.febs.server.system.service.impl;

import com.cxf.febs.server.system.entity.PurchaseRecord;
import com.cxf.febs.server.system.mapper.PurchaseRecordMapper;
import com.cxf.febs.server.system.service.IPurchaseRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxf.febs.common.core.entity.QueryRequest;

import java.util.List;

/**
 * 购买记录表 Service实现
 *
 * @author sixpence
 * @date 2021-10-18 09:54:45
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PurchaseRecordServiceImpl extends ServiceImpl<PurchaseRecordMapper, PurchaseRecord> implements IPurchaseRecordService {

    private final PurchaseRecordMapper purchaseRecordMapper;

    @Override
    public IPage<PurchaseRecord> findPurchaseRecords(QueryRequest request, PurchaseRecord purchaseRecord) {
        LambdaQueryWrapper<PurchaseRecord> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseRecord> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseRecord> findPurchaseRecords(PurchaseRecord purchaseRecord) {
        LambdaQueryWrapper<PurchaseRecord> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createPurchaseRecord(PurchaseRecord purchaseRecord) {
        this.save(purchaseRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePurchaseRecord(PurchaseRecord purchaseRecord) {
        this.saveOrUpdate(purchaseRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePurchaseRecord(PurchaseRecord purchaseRecord) {
        LambdaQueryWrapper<PurchaseRecord> wapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wapper);
    }
}

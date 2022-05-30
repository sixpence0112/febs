package com.cxf.febs.server.system.service.impl;

import com.cxf.febs.server.system.entity.FundGroup;
import com.cxf.febs.server.system.mapper.FundGroupMapper;
import com.cxf.febs.server.system.service.IFundGroupService;
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
 * 基金-基金分组关连表 Service实现
 *
 * @author sixpence
 * @date 2021-10-18 15:46:22
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FundGroupServiceImpl extends ServiceImpl<FundGroupMapper, FundGroup> implements IFundGroupService {

    private final FundGroupMapper fundGroupMapper;

    @Override
    public IPage<FundGroup> findFundGroups(QueryRequest request, FundGroup fundGroup) {
        LambdaQueryWrapper<FundGroup> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<FundGroup> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<FundGroup> findFundGroups(FundGroup fundGroup) {
        LambdaQueryWrapper<FundGroup> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createFundGroup(FundGroup fundGroup) {
        this.save(fundGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFundGroup(FundGroup fundGroup) {
        this.saveOrUpdate(fundGroup);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteFundGroup(FundGroup fundGroup) {
        LambdaQueryWrapper<FundGroup> wapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wapper);
    }
}

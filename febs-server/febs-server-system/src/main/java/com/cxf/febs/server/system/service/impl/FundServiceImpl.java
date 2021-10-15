package com.cxf.febs.server.system.service.impl;

import com.cxf.febs.server.system.entity.Fund;
import com.cxf.febs.server.system.mapper.FundMapper;
import com.cxf.febs.server.system.service.IFundService;
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
 * 基金表 Service实现
 *
 * @author sixpence
 * @date 2021-10-15 17:20:13
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FundServiceImpl extends ServiceImpl<FundMapper, Fund> implements IFundService {

    private final FundMapper fundMapper;

    @Override
    public IPage<Fund> findFunds(QueryRequest request, Fund fund) {
        LambdaQueryWrapper<Fund> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Fund> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Fund> findFunds(Fund fund) {
        LambdaQueryWrapper<Fund> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createFund(Fund fund) {
        this.save(fund);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateFund(Fund fund) {
        this.saveOrUpdate(fund);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteFund(Fund fund) {
        LambdaQueryWrapper<Fund> wapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wapper);
    }
}

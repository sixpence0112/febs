package com.cxf.febs.server.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.cxf.febs.common.core.entity.constant.FebsConstant;
import com.cxf.febs.common.core.utils.SortUtil;
import com.cxf.febs.server.system.entity.Fund;
import com.cxf.febs.server.system.entity.FundGroup;
import com.cxf.febs.server.system.mapper.FundMapper;
import com.cxf.febs.server.system.service.IFundGroupService;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private final IFundGroupService fundGroupService;

    @Override
    public IPage<Fund> findFunds(QueryRequest request, Fund fund) {
        Page<Fund> page = new Page<>(request.getPageNum(), request.getPageSize());
        SortUtil.handlePageSort(request, page, "selected", FebsConstant.ORDER_DESC, true);
        return this.fundMapper.findFundPage(page, fund);
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
        fund.setCreateTime(new Date());
        this.save(fund);

        String[] groups = fund.getGroupId().split(StringPool.COMMA);
        setFundGroup(fund, groups);
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

    private void setFundGroup(Fund fund, String[] groups) {
        List<FundGroup> fundGroups = new ArrayList<>();
        Arrays.stream(groups).forEach(groupId -> {
            FundGroup fundGroup = new FundGroup();
            fundGroup.setFundId(fund.getId());
            fundGroup.setGroupId(Integer.valueOf(groupId));
            fundGroups.add(fundGroup);
        });
        this.fundGroupService.saveBatch(fundGroups);
    }
}

package com.cxf.febs.server.system.service.impl;

import com.cxf.febs.server.system.entity.Group;
import com.cxf.febs.server.system.mapper.GroupMapper;
import com.cxf.febs.server.system.service.IGroupService;
import org.apache.commons.lang3.StringUtils;
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
 * 基金分组表 Service实现
 *
 * @author sixpence
 * @date 2021-10-18 10:48:17
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GroupServiceImpl extends ServiceImpl<GroupMapper, Group> implements IGroupService {

    private final GroupMapper groupMapper;

    @Override
    public IPage<Group> findGroups(QueryRequest request, Group group) {
        LambdaQueryWrapper<Group> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Group> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Group> findGroups(Group group) {
        LambdaQueryWrapper<Group> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        queryWrapper.eq(StringUtils.isNotBlank(group.getIsShow()), Group::getIsShow, group.getIsShow());
        queryWrapper.like(StringUtils.isNotBlank(group.getName()), Group::getName, group.getName());

        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createGroup(Group group) {
        this.save(group);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateGroup(Group group) {
        this.saveOrUpdate(group);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteGroup(Group group) {
        LambdaQueryWrapper<Group> wapper = new LambdaQueryWrapper<>();
        // TODO 设置删除条件
        this.remove(wapper);
    }
}

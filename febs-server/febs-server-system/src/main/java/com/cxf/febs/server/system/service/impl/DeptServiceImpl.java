package com.cxf.febs.server.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxf.febs.common.core.entity.DeptTree;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.common.core.entity.Tree;
import com.cxf.febs.common.core.entity.constant.FebsConstant;
import com.cxf.febs.common.core.entity.constant.PageConstant;
import com.cxf.febs.common.core.entity.system.Dept;
import com.cxf.febs.common.core.utils.SortUtil;
import com.cxf.febs.common.core.utils.TreeUtil;
import com.cxf.febs.server.system.mapper.DeptMapper;
import com.cxf.febs.server.system.service.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
@Slf4j
@Service("deptService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public Map<String, Object> findDepts(QueryRequest request, Dept dept) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Dept> depts = findDepts(dept, request);
            List<DeptTree> trees = new ArrayList<>();
            buildTrees(trees, depts);
            List<? extends Tree> deptTree = TreeUtil.build(trees);

            result.put(PageConstant.ROWS, deptTree);
            result.put(PageConstant.TOTAL, depts.size());
        } catch (Exception e) {
            log.error("获取部门列表失败", e);
            result.put(PageConstant.ROWS, null);
            result.put(PageConstant.TOTAL, 0);
        }
        return result;
    }

    @Override
    public List<Dept> findDepts(Dept dept, QueryRequest request) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(dept.getDeptName()))
            queryWrapper.lambda().like(Dept::getDeptName, dept.getDeptName());
        if (StringUtils.isNotBlank(dept.getCreateTimeFrom()) && StringUtils.isNotBlank(dept.getCreateTimeTo()))
            queryWrapper.lambda()
                    .ge(Dept::getCreateTime, dept.getCreateTimeFrom())
                    .le(Dept::getCreateTime, dept.getCreateTimeTo());
        SortUtil.handleWrapperSort(request, queryWrapper, "orderNum", FebsConstant.ORDER_ASC, true);
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createDept(Dept dept) {
        if (dept.getParentId() == null)
            dept.setParentId(0L);
        dept.setCreateTime(new Date());
        this.save(dept);
    }

    @Override
    @Transactional
    public void updateDept(Dept dept) {
        if (dept.getParentId() == null)
            dept.setParentId(0L);
        dept.setModifyTime(new Date());
        this.baseMapper.updateById(dept);
    }

    @Override
    @Transactional
    public void deleteDepts(String[] deptIds) {
        this.delete(Arrays.asList(deptIds));
    }

    private void buildTrees(List<DeptTree> trees, List<Dept> depts) {
        depts.forEach(dept -> {
            DeptTree tree = new DeptTree();
            tree.setId(dept.getDeptId().toString());
            tree.setParentId(dept.getParentId().toString());
            tree.setLabel(dept.getDeptName());
            tree.setOrderNum(dept.getOrderNum());
            trees.add(tree);
        });
    }

    private void delete(List<String> deptIds) {
        removeByIds(deptIds);

        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Dept::getParentId, deptIds);
        List<Dept> depts = baseMapper.selectList(queryWrapper);
        if (CollectionUtils.isNotEmpty(depts)) {
            List<String> deptIdList = new ArrayList<>();
            depts.forEach(d -> deptIdList.add(String.valueOf(d.getDeptId())));
            this.delete(deptIdList);
        }
    }
}

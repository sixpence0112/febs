package com.cxf.febs.server.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxf.febs.common.entity.system.RoleMenu;
import com.cxf.febs.server.system.mapper.RoleMenuMapper;
import com.cxf.febs.server.system.service.IRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
@Service("roleMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Override
    @Transactional
    public void deleteRoleMenusByRoleId(String[] roleIds) {
        List<String> list = Arrays.asList(roleIds);
        baseMapper.delete(new LambdaQueryWrapper<RoleMenu>().in(RoleMenu::getRoleId, list));
    }

    @Override
    @Transactional
    public void deleteRoleMenusByMenuId(String[] menuIds) {
        List<String> list = Arrays.asList(menuIds);
        baseMapper.delete(new LambdaQueryWrapper<RoleMenu>().in(RoleMenu::getMenuId, list));
    }

    @Override
    public List<RoleMenu> getRoleMenusByRoleId(String roleId) {
        return baseMapper.selectList(new LambdaQueryWrapper<RoleMenu>().eq(RoleMenu::getRoleId, roleId));
    }
}
package com.cxf.febs.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.entity.system.RoleMenu;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    void deleteRoleMenusByRoleId(String[] roleIds);

    void deleteRoleMenusByMenuId(String[] menuIds);

    List<RoleMenu> getRoleMenusByRoleId(String roleId);
}

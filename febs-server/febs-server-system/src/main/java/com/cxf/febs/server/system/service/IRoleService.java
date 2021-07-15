package com.cxf.febs.server.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.common.core.entity.system.Role;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
public interface IRoleService extends IService<Role> {

    IPage<Role> findRoles(Role role, QueryRequest request);

    List<Role> findUserRole(String userName);

    List<Role> findAllRoles();

    Role findByName(String roleName);

    void createRole(Role role);

    void deleteRoles(String[] roleIds);

    void updateRole(Role role);
}

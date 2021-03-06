package com.cxf.febs.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.core.entity.system.UserRole;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2020/10/14
 */
public interface IUserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);

    List<String> findUserIdsByRoleId(String[] roleIds);
}

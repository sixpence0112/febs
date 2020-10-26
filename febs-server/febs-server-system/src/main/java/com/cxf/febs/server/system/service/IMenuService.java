package com.cxf.febs.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.entity.router.VueRouter;
import com.cxf.febs.common.entity.system.Menu;

import java.util.List;
import java.util.Set;

/**
 * @author sixpence
 * @version 1.0 2020/10/23
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 通过用户名查询用户权限信息
     *
     * @param username 用户名
     * @return 权限信息
     */
    Set<String> findUserPermissions(String username);

    /**
     * 通过用户名创建对应的 Vue路由信息
     *
     * @param username 用户名
     * @return 路由信息
     */
    List<VueRouter<Menu>> getUserRouters(String username);
}

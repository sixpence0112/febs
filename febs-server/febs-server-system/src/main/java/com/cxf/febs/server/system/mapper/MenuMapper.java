package com.cxf.febs.server.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxf.febs.common.core.entity.system.Menu;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2020/10/23
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户名查询权限信息
     *
     * @param username 用户名称
     * @return 权限信息
     */
    List<Menu> findUserPermissions(String username);

    /**
     * 通过用户名查询菜单信息
     *
     * @param username 用户名
     * @return 菜单信息
     */
    List<Menu> findUserMenus(String username);
}

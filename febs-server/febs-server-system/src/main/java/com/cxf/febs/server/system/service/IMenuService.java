package com.cxf.febs.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.entity.router.VueRouter;
import com.cxf.febs.common.entity.system.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sixpence
 * @version 1.0 2020/10/23
 */
public interface IMenuService extends IService<Menu> {

    String findUserPermissions(String username);

    List<Menu> findUserMenus(String username);

    Map<String, Object> findMenus(Menu menu);

    List<VueRouter<Menu>> getUserRouters(String username);

    List<Menu> findMenuList(Menu menu);

    void createMenu(Menu menu);

    void updateMenu(Menu menu);

    /**
     * 递归删除菜单/按钮
     *
     * @param menuIds menuIds
     */
    void deleteMeuns(String[] menuIds);
}

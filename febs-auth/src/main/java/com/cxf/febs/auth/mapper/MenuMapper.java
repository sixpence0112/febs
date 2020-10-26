package com.cxf.febs.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxf.febs.common.entity.system.Menu;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2020/10/10
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户名查找用户权限
     *
     * @param username
     * @return
     */
    List<Menu> findUserPermissions(String username);

}

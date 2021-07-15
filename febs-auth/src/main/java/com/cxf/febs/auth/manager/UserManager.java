package com.cxf.febs.auth.manager;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.cxf.febs.auth.mapper.MenuMapper;
import com.cxf.febs.auth.mapper.UserMapper;
import com.cxf.febs.auth.mapper.UserRoleMapper;
import com.cxf.febs.common.core.entity.constant.FebsConstant;
import com.cxf.febs.common.core.entity.system.Menu;
import com.cxf.febs.common.core.entity.system.SystemUser;
import com.cxf.febs.common.core.entity.system.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用于统一定义和用户相关的业务方法
 * @author sixpence
 * @version 1.0 2020/10/10
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class UserManager {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     *通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户
     */
    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    /**
     * 通过用户名查询用户权限串
     *
     * @param username 用户名
     * @return 权限
     */
    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);

        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(StringPool.COMMA));
    }

    /**
     * 注册用户
     *
     * @param username username
     * @param password password
     * @return SystemUser SystemUser
     */
    @Transactional
    public SystemUser registUser(String username, String password) {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(username);
        systemUser.setPassword(password);
        systemUser.setCreateTime(new Date());
        systemUser.setStatus(SystemUser.STATUS_VALID);
        systemUser.setSex(SystemUser.SEX_UNKNOW);
        systemUser.setAvatar(SystemUser.DEFAULT_AVATAR);
        systemUser.setDescription("注册用户");
        this.userMapper.insert(systemUser);

        UserRole userRole = new UserRole();
        userRole.setRoleId(FebsConstant.REGISTER_ROLE_ID);
        userRole.setUserId(systemUser.getUserId());
        this.userRoleMapper.insert(userRole);

        return systemUser;
    }
}

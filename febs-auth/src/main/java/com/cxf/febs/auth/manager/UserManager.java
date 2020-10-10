package com.cxf.febs.auth.manager;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.cxf.febs.auth.mapper.MenuMapper;
import com.cxf.febs.auth.mapper.UserMapper;
import com.cxf.febs.common.entity.system.Menu;
import com.cxf.febs.common.entity.system.SystemUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用于统一定义和用户相关的业务方法
 * @author sixpence
 * @version 1.0 2020/10/10
 */
@Service
public class UserManager {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);

        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(StringPool.COMMA));
    }
}

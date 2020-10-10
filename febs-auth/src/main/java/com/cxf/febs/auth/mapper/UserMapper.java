package com.cxf.febs.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxf.febs.common.entity.system.SystemUser;

/**
 * @author sixpence
 * @version 1.0 2020/10/10
 */
public interface UserMapper extends BaseMapper<SystemUser> {
    SystemUser findByName(String username);
}

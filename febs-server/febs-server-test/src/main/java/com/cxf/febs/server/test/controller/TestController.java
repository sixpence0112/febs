package com.cxf.febs.server.test.controller;

import com.cxf.febs.common.entity.FebsResponse;
import com.cxf.febs.common.entity.QueryRequest;
import com.cxf.febs.common.entity.system.SystemUser;
import com.cxf.febs.server.test.service.IHelloService;
import com.cxf.febs.server.test.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author sixpence
 * @version 1.0 2020/9/21
 */
@Slf4j
@RestController
@RequestMapping
public class TestController {

    @Autowired
    private IUserService userService;

    /**
     * 用于演示 Feign调用受保护的远程方法
     */
    @GetMapping("user/list")
    public FebsResponse getRemoteUserList(QueryRequest request, SystemUser user) {
        return userService.userList(request, user);
    }

    /**
     * 获取当前用户信息
     *
     * @param principal principal
     * @return Principal
     */
    @GetMapping("user")
    public Principal currentUser(Principal principal) {
        return principal;
    }
}

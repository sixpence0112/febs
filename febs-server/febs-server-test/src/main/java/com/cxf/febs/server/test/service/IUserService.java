package com.cxf.febs.server.test.service;

import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.common.core.entity.constant.FebsServerConstant;
import com.cxf.febs.common.core.entity.system.SystemUser;
import com.cxf.febs.server.test.service.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign客户端
 *
 * @author sixpence
 * @version 1.0 2021/1/4
 */
@FeignClient(value = FebsServerConstant.FEBS_SERVER_SYSTEM, contextId = "userServiceClient", fallbackFactory = UserServiceFallback.class)
public interface IUserService {

    @GetMapping("user")
    FebsResponse userList(@RequestParam("queryRequest") QueryRequest queryRequest, @RequestParam("user") SystemUser user);
}

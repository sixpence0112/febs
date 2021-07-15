package com.cxf.febs.server.test.service.fallback;

import com.cxf.febs.common.core.annotation.Fallback;
import com.cxf.febs.server.test.service.IUserService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
@Slf4j
@Fallback
public class UserServiceFallback implements FallbackFactory<IUserService> {

    @Override
    public IUserService create(Throwable throwable) {
        return (p, u) -> {
            log.error("获取用户信息失败", throwable);
            return null;
        };
    }
}

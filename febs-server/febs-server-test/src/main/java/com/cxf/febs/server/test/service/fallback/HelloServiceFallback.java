package com.cxf.febs.server.test.service.fallback;

import com.cxf.febs.server.test.service.IHelloService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author sixpence
 * @version 1.0 2020/9/28
 */
@Slf4j
@Component
public class HelloServiceFallback implements FallbackFactory<IHelloService> {
    @Override
    public IHelloService create(Throwable throwable) {
        /*return new IHelloService() {
            @Override
            public String hello(String name) {
                log.error("调用febs-server-system服务出错", throwable);
                return "调用出错";
            }
        };*/
        return name -> {
            log.error("调用febs-server-system服务出错", throwable);
            return "调用出错";
        };
    }
}

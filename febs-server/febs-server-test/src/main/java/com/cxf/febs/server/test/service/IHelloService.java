package com.cxf.febs.server.test.service;

import com.cxf.febs.common.entity.constant.FebsServerConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sixpence
 * @version 1.0 2020/9/28
 */
@FeignClient(value = FebsServerConstant.FEBS_SERVER_SYSTEM, contextId = "helloServiceClient")
public interface IHelloService {

    @GetMapping("hello")
    String hello(@RequestParam("name") String name);
}

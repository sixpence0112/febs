package com.cxf.febs.gateway.enhance.runner;

import com.cxf.febs.gateway.enhance.service.BlackListService;
import com.cxf.febs.gateway.enhance.service.RateLimitRuleService;
import com.cxf.febs.gateway.enhance.service.RouteEnhanceCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

/**
 * @author sixpence
 * @version 1.0 2021/9/24
 */
@RequiredArgsConstructor
public class FebsRouteEnhanceRunner implements ApplicationRunner {

    private final RouteEnhanceCacheService cacheService;
    private final BlackListService blackListService;
    private final RateLimitRuleService rateLimitRuleService;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("已开启网关增强功能：请求日志、黑名单&限流。");
        cacheService.saveAllBlackList(blackListService.findAll());
        cacheService.saveAllRateLimitRules(rateLimitRuleService.findAll());
    }
}

package com.cxf.febs.gateway.enhance.configure;

import com.cxf.febs.common.core.entity.constant.FebsConstant;
import com.cxf.febs.gateway.enhance.runner.FebsRouteEnhanceRunner;
import com.cxf.febs.gateway.enhance.service.BlackListService;
import com.cxf.febs.gateway.enhance.service.RateLimitRuleService;
import com.cxf.febs.gateway.enhance.service.RouteEnhanceCacheService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sixpence
 * @version 1.0 2021/9/23
 */
@EnableAsync
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.cxf.febs.gateway.enhance.mapper")
@ConditionalOnProperty(name = "febs.gateway.enhance", havingValue = "true")
public class FebsRouteEnhanceConfigure {

    @Bean(FebsConstant.ASYNC_POOL)
    public ThreadPoolTaskExecutor asyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(30);
        executor.setThreadNamePrefix("Febs-Gateway-Async-Thread");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setAwaitTerminationSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Bean
    public ApplicationRunner febsRouteEnhanceRunner(RouteEnhanceCacheService cacheService,
                                                    BlackListService blackListService,
                                                    RateLimitRuleService rateLimitRuleService) {
        return new FebsRouteEnhanceRunner(cacheService, blackListService, rateLimitRuleService);
    }
}

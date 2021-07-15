package com.cxf.febs.common.core.configure;

import com.cxf.febs.common.core.handler.FebsAccessDeniedHandler;
import com.cxf.febs.common.core.handler.FebsAuthExceptionEntryPoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author sixpence
 * @version 1.0 2020/9/27
 */
public class FebsAuthExceptionConfigure {

    @Bean
    @ConditionalOnMissingBean(name = "accessDeniedHandler")
    public FebsAccessDeniedHandler accessDeniedHandler() {
        return new FebsAccessDeniedHandler();
    }

    @Bean
    @ConditionalOnMissingBean(name = "authExceptionEntryPoint")
    public FebsAuthExceptionEntryPoint authExceptionEntryPoint() {
        return new FebsAuthExceptionEntryPoint();
    }
}

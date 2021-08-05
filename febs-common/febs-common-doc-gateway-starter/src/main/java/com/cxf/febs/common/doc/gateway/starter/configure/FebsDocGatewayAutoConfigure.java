package com.cxf.febs.common.doc.gateway.starter.configure;

import com.cxf.febs.common.doc.gateway.starter.filter.FebsDocGatewayHeaderFilter;
import com.cxf.febs.common.doc.gateway.starter.handler.FebsDocGatewayHandler;
import com.cxf.febs.common.doc.gateway.starter.properties.FebsDocGatewayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger.web.UiConfiguration;

/**
 * @author sixpence
 * @version 1.0 2021/8/4
 */
@Configuration
@EnableConfigurationProperties(FebsDocGatewayProperties.class)
@ConditionalOnProperty(value = "febs.doc.gateway.enable", havingValue = "true", matchIfMissing = true)
public class FebsDocGatewayAutoConfigure {

    private final FebsDocGatewayProperties properties;
    private SecurityConfiguration securityConfiguration;
    private UiConfiguration uiConfiguration;

    public FebsDocGatewayAutoConfigure(FebsDocGatewayProperties properties) {
        this.properties = properties;
    }

    @Autowired(required = false)
    public void setSecurityConfiguration(SecurityConfiguration securityConfiguration) {
        this.securityConfiguration = securityConfiguration;
    }

    @Autowired(required = false)
    public void setUiConfiguration(UiConfiguration uiConfiguration) {
        this.uiConfiguration = uiConfiguration;
    }

    @Bean
    public FebsDocGatewayResourceConfigure febsDocGatewayResourceConfigure(RouteLocator routeLocator, GatewayProperties gatewayProperties) {
        return new FebsDocGatewayResourceConfigure(routeLocator, gatewayProperties);
    }

    @Bean
    public FebsDocGatewayHeaderFilter febsDocGatewayHeaderFilter() {
        return new FebsDocGatewayHeaderFilter();
    }

    @Bean
    public FebsDocGatewayHandler febsDocGatewayHandler(SwaggerResourcesProvider swaggerResources) {
        FebsDocGatewayHandler febsDocGatewayHandler = new FebsDocGatewayHandler();
        febsDocGatewayHandler.setSecurityConfiguration(securityConfiguration);
        febsDocGatewayHandler.setUiConfiguration(uiConfiguration);
        febsDocGatewayHandler.setSwaggerResources(swaggerResources);
        febsDocGatewayHandler.setProperties(properties);
        return febsDocGatewayHandler;
    }
}

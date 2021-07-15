package com.cxf.febs.common.core.annotation;

import com.cxf.febs.common.core.configure.FebsOAuth2FeignConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 让配置类FebsOAuth2FeignConfigure生效
 *
 * @author sixpence
 * @version 1.0 2020/9/30
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FebsOAuth2FeignConfigure.class)
public @interface EnableFebsOauth2FeignClient {
}

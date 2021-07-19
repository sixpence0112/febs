package com.cxf.febs.common.security.starter.annotation;

import com.cxf.febs.common.security.starter.configure.FebsCloudResourcesServerConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sixpence
 * @version 1.0 2021/7/19
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FebsCloudResourcesServerConfigure.class)
public @interface EnableFebsCloudResourceServer {
}

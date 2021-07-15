package com.cxf.febs.common.core.annotation;

import com.cxf.febs.common.core.configure.FebsLettuceRedisConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sixpence
 * @version 1.0 2020/10/10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FebsLettuceRedisConfigure.class)
public @interface EnableFebsLettuceRedis {
}

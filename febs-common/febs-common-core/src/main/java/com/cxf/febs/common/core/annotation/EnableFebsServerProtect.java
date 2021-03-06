package com.cxf.febs.common.core.annotation;

import com.cxf.febs.common.core.configure.FebsServerProtectConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author sixpence
 * @version 1.0 2020/10/9
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FebsServerProtectConfigure.class)
public @interface EnableFebsServerProtect {
}

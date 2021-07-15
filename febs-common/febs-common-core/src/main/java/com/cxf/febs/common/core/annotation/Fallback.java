package com.cxf.febs.common.core.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author sixpence
 * @version 1.0 2020/12/30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Fallback {

    @AliasFor(annotation = Component.class)
    String value() default "";
}

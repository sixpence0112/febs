package com.cxf.febs.common.core.entity.constant;

import java.util.regex.Pattern;

/**
 * 正则表达式常量
 *
 * @author sixpence
 * @version 1.0 2020/10/14
 */
public interface RegexpConstant {

    /**
     * 简单手机号正则（这里只是简单校验是否为 11位，实际规则更复杂）
     */
    String MOBILE_REG = "[1]\\d{10}";
    /**
     * 中文正则
     */
    Pattern CHINESE = Pattern.compile("[\u4e00-\u9fa5]");
}

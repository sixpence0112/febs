package com.cxf.febs.common.entity;

/**
 * 正则表达式常量
 * @author sixpence
 * @version 1.0 2020/10/14
 */
public class RegexpConstant {

    // 简单手机号正则（这里只是简单校验是否为 11位，实际规则更复杂）
    public static final String MOBILE_REG = "[1]\\d{10}";
}

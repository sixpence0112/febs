package com.cxf.febs.common.entity.system;

import lombok.Data;

/**
 * @author sixpence
 * @version 1.0 2020/12/31
 */
@Data
public class Colunm {
    /**
     * 名称
     */
    private String name;
    /**
     * 是否为主键
     */
    private Boolean isKey;
    /**
     * 类型
     */
    private String type;
    /**
     * 注释
     */
    private String remark;
    /**
     * 属性名称
     */
    private String field;
}
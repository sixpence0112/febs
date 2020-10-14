package com.cxf.febs.common.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分页查询参数类
 * @author sixpence
 * @version 1.0 2020/10/14
 */
@Data
@ToString
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -6747190914504830854L;

    /**
     * 当前页面数据量
     */
    private int pageSize = 10;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则，asc升序，desc降序
     */
    private String order;
}

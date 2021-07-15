package com.cxf.febs.canal.entity;

import lombok.Data;

/**
 * @author sixpence
 * @version 1.0 2021/6/8
 */
@Data
public class MysqlType {
    private String id;
    private String commodity_name;
    private String commodity_price;
    private String number;
    private String description;
}


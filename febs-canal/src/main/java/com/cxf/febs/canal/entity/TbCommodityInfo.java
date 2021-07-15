package com.cxf.febs.canal.entity;

import lombok.Data;

/**
 * @author sixpence
 * @version 1.0 2021/6/8
 */
@Data
public class TbCommodityInfo {
    private String id;
    private String commodityName;
    private String commodityPrice;
    private int number;
    private String description;
}

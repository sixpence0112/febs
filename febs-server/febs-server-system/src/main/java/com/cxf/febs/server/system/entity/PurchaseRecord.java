package com.cxf.febs.server.system.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* 购买记录表 Entity
*
* @author sixpence
* @date 2021-10-18 09:54:45
*/
@Data
@TableName("t_purchase_record")
public class PurchaseRecord {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 基金代码
     */
    @TableField("fund_code")
    private String fundCode;

    /**
     * 购买金额
     */
    @TableField("amount")
    private String amount;

    /**
     * 购买周日期
     */
    @TableField("weekday")
    private String weekday;

    /**
     * 购买日期
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;

    /**
     * 
     */
    @TableField("net_worth")
    private String netWorth;

}
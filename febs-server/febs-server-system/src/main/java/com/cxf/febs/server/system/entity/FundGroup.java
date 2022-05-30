package com.cxf.febs.server.system.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* 基金-基金分组关连表 Entity
*
* @author sixpence
* @date 2021-10-18 15:46:22
*/
@Data
@TableName("t_fund_group")
public class FundGroup {

    /**
     * 基金id
     */
    @TableId(value = "fund_id", type = IdType.AUTO)
    private Integer fundId;

    /**
     * 基金分组id
     */
    @TableId(value = "group_id", type = IdType.AUTO)
    private Integer groupId;

}
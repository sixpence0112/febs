package com.cxf.febs.server.system.entity;

import java.util.Date;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
* 基金分组表 Entity
*
* @author sixpence
* @date 2021-10-18 10:48:17
*/
@Data
@TableName("t_group")
public class Group {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分组名称
     */
    @TableField("name")
    private String name;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;

    /**
     * 是否展示（0：不展示，1：展示）
     */
    @TableField("is_show")
    private String isShow;

    private transient String createTimeFrom;
    private transient String createTimeTo;

}
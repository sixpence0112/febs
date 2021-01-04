package com.cxf.febs.common.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author sixpence
 * @version 1.0 2020/12/31
 */
@Data
@TableName("t_role_menu")
public class RoleMenu {

    private static final long serialVersionUID = -7573904024872252113L;

    @TableField(value = "ROLE_ID")
    private Long roleId;
    @TableField(value = "MENU_ID")
    private Long menuId;
}

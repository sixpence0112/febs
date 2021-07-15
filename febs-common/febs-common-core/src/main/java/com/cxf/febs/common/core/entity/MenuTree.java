package com.cxf.febs.common.core.entity;

import com.cxf.febs.common.core.entity.system.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sixpence
 * @version 1.0 2020/12/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuTree extends Tree<Menu> {

    private String path;
    private String component;
    private String perms;
    private String icon;
    private String type;
    private Integer orderNum;
}

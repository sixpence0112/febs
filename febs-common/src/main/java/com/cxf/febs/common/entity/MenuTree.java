package com.cxf.febs.common.entity;

import com.cxf.febs.common.entity.system.Menu;

/**
 * @author sixpence
 * @version 1.0 2020/12/30
 */
public class MenuTree extends Tree<Menu> {

    private String path;
    private String component;
    private String perms;
    private String icon;
    private String type;
    private Integer orderNum;
}
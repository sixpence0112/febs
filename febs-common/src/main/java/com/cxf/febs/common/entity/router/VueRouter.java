package com.cxf.febs.common.entity.router;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import feign.hystrix.FallbackFactory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2020/10/23
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VueRouter<T> implements Serializable {

    private static final long serialVersionUID = -2439230724760998686L;

    @JsonIgnore
    private String id;
    @JsonIgnore
    private String parentId;
    /**
     * 对应路由path
     */
    private String path;
    /**
     * 路由名称
     */
    private String name;
    /**
     * 对应路由组件
     */
    private String component;
    /**
     * 重定向地址
     */
    private String redirect;
    /**
     * 路由元信息
     */
    private RouterMeta meta;
    /**
     * 是否渲染在菜单上
     */
    private Boolean hidden = false;
    /**
     * 是否一直显示根路由
     */
    private Boolean alwaysShow = false;
    /**
     * 子路由
     */
    private List<VueRouter<T>> children;

    @JsonIgnore
    private Boolean hasParent = false;

    @JsonIgnore
    private Boolean hasChildren = false;

    public void initChildren() {
        this.children = new ArrayList<>();
    }
}

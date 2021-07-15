package com.cxf.febs.common.core.entity.router;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sixpence
 * @version 1.0 2020/10/23
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouterMeta implements Serializable {

    private static final long serialVersionUID = -7140886625846363715L;
    /**
     * 标题
     */
    private String title;
    /**
     * 图标
     */
    private String icon;

    private Boolean breadcrumb = true;

    public RouterMeta(String menuName, String icon) {
    }
}

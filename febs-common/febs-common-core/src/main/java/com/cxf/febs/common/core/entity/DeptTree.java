package com.cxf.febs.common.core.entity;

import com.cxf.febs.common.core.entity.system.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sixpence
 * @version 1.0 2020/12/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends Tree<Dept> {

    private Integer orderNum;
}

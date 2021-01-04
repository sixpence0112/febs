package com.cxf.febs.common.entity;

import com.cxf.febs.common.entity.system.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.security.auth.Subject;

/**
 * @author sixpence
 * @version 1.0 2020/12/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends Tree<Dept> {

    private Integer orderNum;
}

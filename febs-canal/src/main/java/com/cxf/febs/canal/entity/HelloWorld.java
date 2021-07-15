package com.cxf.febs.canal.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import lombok.Data;

import java.util.Date;

/**
 * @author sixpence
 * @version 1.0 2021/6/18
 */
@Data
public class HelloWorld {
    private Long id;

    private String sayHello;

    private String yourName;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isDeleted;
}

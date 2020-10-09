package com.cxf.febs.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sixpence
 * @version 1.0 2020/9/18
 */
@Data
public class FebsAuthUser implements Serializable {

    private static final long serialVersionUID = 6493593806412130409L;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;
}

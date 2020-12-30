package com.cxf.febs.auth.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author sixpence
 * @version 1.0 2020/12/29
 */
@Data
public class BindUser implements Serializable {

    private static final long serialVersionUID = -2000515678135225003L;

    @NotBlank(message = "{required}")
    private String bindUsername;
    @NotBlank(message = "{required}")
    private String bindPassword;
}

package com.cxf.febs.common.validator;

import com.cxf.febs.common.annotation.IsMobile;
import com.cxf.febs.common.entity.RegexpConstant;
import com.cxf.febs.common.utils.FebsUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * @author sixpence
 * @version 1.0 2020/10/14
 */
public class MobileValidator implements ConstraintValidator<IsMobile, String> {

    @Override
    public void initialize(IsMobile isMobile) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        try {
            if (StringUtils.isBlank(s)) {
                return true;
            } else {
                String regex = RegexpConstant.MOBILE_REG;
                return FebsUtil.match(regex, s);
            }
        } catch (Exception e) {
            return false;
        }
    }
}

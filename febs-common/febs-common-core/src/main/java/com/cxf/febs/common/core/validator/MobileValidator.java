package com.cxf.febs.common.core.validator;

import com.cxf.febs.common.core.annotation.IsMobile;
import com.cxf.febs.common.core.entity.constant.RegexpConstant;
import com.cxf.febs.common.core.utils.FebsUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


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

package com.cxf.febs.server.system.aspect;

import com.cxf.febs.common.annotation.ControllerEndpoint;
import com.cxf.febs.common.exception.FebsException;
import com.cxf.febs.common.utils.FebsUtil;
import com.cxf.febs.common.utils.HttpContextUtil;
import com.cxf.febs.server.system.service.ILogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
@Aspect
@Component
public class ControllerEndpointAspect extends AspectSupport {

    @Autowired
    private ILogService logService;

    @Pointcut("@annotation(com.cxf.febs.common.annotation.ControllerEndpoint)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws FebsException {
        Object result;
        Method targetMethod = resolveMethod(point);
        ControllerEndpoint annotation = targetMethod.getAnnotation(ControllerEndpoint.class);
        String operation = annotation.operation();
        long start = System.currentTimeMillis();
        try {
            result = point.proceed();
            if (StringUtils.isNotBlank(operation)) {
                HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                String username = (String) authentication.getPrincipal();
                logService.saveLog(point, targetMethod, request, operation, username, start);
            }
            return result;
        } catch (Throwable throwable) {
            String exceptionMessage = annotation.exceptionMessage();
            String message = throwable.getMessage();
            String error = FebsUtil.containChinese(message) ? exceptionMessage + "，" + message : exceptionMessage;
            throw new FebsException(error);
        }
    }

}

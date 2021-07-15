package com.cxf.febs.common.core.selector;

import com.cxf.febs.common.core.configure.FebsAuthExceptionConfigure;
import com.cxf.febs.common.core.configure.FebsOAuth2FeignConfigure;
import com.cxf.febs.common.core.configure.FebsServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author sixpence
 * @version 1.0 2020/10/9
 */
public class FebsCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                FebsAuthExceptionConfigure.class.getName(),
                FebsServerProtectConfigure.class.getName(),
                FebsOAuth2FeignConfigure.class.getName()
        };
    }
}

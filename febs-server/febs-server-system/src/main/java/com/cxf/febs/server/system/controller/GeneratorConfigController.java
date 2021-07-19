package com.cxf.febs.server.system.controller;

import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.entity.system.GeneratorConfig;
import com.cxf.febs.common.core.exception.FebsException;
import com.cxf.febs.server.system.annotation.ControllerEndpoint;
import com.cxf.febs.server.system.service.IGeneratorConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
@Slf4j
@RestController
@RequestMapping("generatorConfig")
public class GeneratorConfigController {

    @Autowired
    private IGeneratorConfigService generatorConfigService;

    @GetMapping
    @PreAuthorize("hasAuthority('gen:config')")
    public FebsResponse getGeneratorConfig() {
        return new FebsResponse().data(generatorConfigService.findGeneratorConfig());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('gen:config:update')")
    @ControllerEndpoint(operation = "修改生成代码配置", exceptionMessage = "修改GeneratorConfig失败")
    public void updateGeneratorConfig(@Valid GeneratorConfig generatorConfig) throws FebsException {
        if (StringUtils.isBlank(generatorConfig.getId()))
            throw new FebsException("配置id不能为空");
        this.generatorConfigService.updateGeneratorConfig(generatorConfig);
    }
}

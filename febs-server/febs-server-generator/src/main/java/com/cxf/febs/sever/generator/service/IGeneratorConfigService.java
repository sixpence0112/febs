package com.cxf.febs.sever.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.core.entity.system.GeneratorConfig;

/**
 * @author sixpence
 * @version 1.0 2021/10/14
 */
public interface IGeneratorConfigService extends IService<GeneratorConfig> {

    /**
     *查询
     *
     * @return GeneratorConfig
     */
    GeneratorConfig getGeneratorConfig();

    /**
     * 更新
     *
     * @param generatorConfig generatorConfig
     */
    void updateGeneratorConfig(GeneratorConfig generatorConfig);
}

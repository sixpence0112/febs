package com.cxf.febs.sever.generator.runner;

import com.cxf.febs.common.core.utils.FebsUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author sixpence
 * @version 1.0 2021/10/15
 */
@Component
@RequiredArgsConstructor
public class StartedUUpRunner implements ApplicationRunner {

    private final ConfigurableApplicationContext context;
    private final Environment environment;

    @Override
    public void run(ApplicationArguments args) {
        if (context.isActive()) {
            FebsUtil.printSystemUpBanner(environment);
        }
    }
}

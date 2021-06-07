package com.cxf.febs.server.system.module;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 把数据源设置到Hasor容器中
 * @author sixpence
 * @version 1.0 2021/4/6
 */
@DimModule
@Component
public class DatawayModule implements SpringModule {

    @Autowired
    private DataSource dataSource = null;

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        // .DataSource from Spring boot into Hasor
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));

    }
}

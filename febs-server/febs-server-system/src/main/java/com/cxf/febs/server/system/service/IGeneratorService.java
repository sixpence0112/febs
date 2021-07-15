package com.cxf.febs.server.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.common.core.entity.system.Column;
import com.cxf.febs.common.core.entity.system.Table;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
public interface IGeneratorService {

    List<String> getDatabases(String databaseType);

    IPage<Table> getTables(String tableName, QueryRequest request, String databaseType, String schemaName);

    List<Column> getColumns(String databaseType, String schemaName, String tableName);
}

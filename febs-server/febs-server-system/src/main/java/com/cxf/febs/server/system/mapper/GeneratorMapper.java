package com.cxf.febs.server.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxf.febs.common.core.entity.system.Column;
import com.cxf.febs.common.core.entity.system.Table;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
public interface GeneratorMapper {


    List<String> getDatabases(@Param("databaseType") String databaseType);

    IPage<Table> getTables(Page page, @Param("tableName") String tableName, @Param("databaseType") String databaseType, @Param("schemaName") String schemaName);

    List<Column> getColumns(@Param("databaseType") String databaseType, @Param("schemaName") String schemaName, @Param("tableName") String tableName);
}

package com.cxf.febs.sever.generator.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.common.core.entity.constant.FebsConstant;
import com.cxf.febs.common.core.entity.system.Column;
import com.cxf.febs.common.core.entity.system.Table;
import com.cxf.febs.common.core.utils.SortUtil;
import com.cxf.febs.sever.generator.mapper.GeneratorMapper;
import com.cxf.febs.sever.generator.service.IGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2021/10/14
 */
@Service
@RequiredArgsConstructor
public class GeneratorServiceImpl implements IGeneratorService {

    private final GeneratorMapper generatorMapper;

    @Override
    public List<String> getDatabasees(String databaseType) {
        return generatorMapper.getDatabases(databaseType);
    }

    @Override
    public IPage<Table> getTables(String tableName, QueryRequest request, String databaseType, String schemaName) {
        Page<Table> page = new Page<>(request.getPageNum(), request.getPageSize());
        SortUtil.handlePageSort(request, page, "createTime", FebsConstant.ORDER_DESC, false);
        return generatorMapper.getTables(page, tableName, databaseType, schemaName);
    }

    @Override
    public List<Column> getColumns(String databaseType, String schemaName, String tableName) {
        return generatorMapper.getColumns(databaseType, schemaName, tableName);
    }
}

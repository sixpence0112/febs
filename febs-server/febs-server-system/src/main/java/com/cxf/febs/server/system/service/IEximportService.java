package com.cxf.febs.server.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.common.core.entity.system.Eximport;

import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
public interface IEximportService extends IService<Eximport> {

    /**
     * 查询（分页）
     *
     * @param request  QueryRequest
     * @param eximport eximport
     * @return IPage<Eximport>
     */
    IPage<Eximport> findEximports(QueryRequest request, Eximport eximport);


    /**
     * 批量插入
     *
     * @param list List<Eximport>
     */
    void batchInsert(List<Eximport> list);
}

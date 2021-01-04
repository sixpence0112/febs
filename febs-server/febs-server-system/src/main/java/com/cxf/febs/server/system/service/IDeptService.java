package com.cxf.febs.server.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cxf.febs.common.entity.QueryRequest;
import com.cxf.febs.common.entity.system.Dept;

import java.util.List;
import java.util.Map;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
public interface IDeptService extends IService<Dept> {

    Map<String, Object> findDepts(QueryRequest request, Dept dept);

    List<Dept> findDepts(Dept dept, QueryRequest request);

    void createDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDepts(String[] deptIds);
}

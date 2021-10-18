package com.cxf.febs.server.system.service;

import com.cxf.febs.server.system.entity.Group;

import com.cxf.febs.common.core.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 基金分组表 Service接口
 *
 * @author sixpence
 * @date 2021-10-18 10:48:17
 */
public interface IGroupService extends IService<Group> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param group group
     * @return IPage<Group>
     */
    IPage<Group> findGroups(QueryRequest request, Group group);

    /**
     * 查询（所有）
     *
     * @param group group
     * @return List<Group>
     */
    List<Group> findGroups(Group group);

    /**
     * 新增
     *
     * @param group group
     */
    void createGroup(Group group);

    /**
     * 修改
     *
     * @param group group
     */
    void updateGroup(Group group);

    /**
     * 删除
     *
     * @param group group
     */
    void deleteGroup(Group group);
}

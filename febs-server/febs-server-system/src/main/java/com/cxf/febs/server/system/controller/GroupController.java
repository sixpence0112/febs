package com.cxf.febs.server.system.controller;

import com.cxf.febs.server.system.entity.Group;
import com.cxf.febs.server.system.service.IGroupService;
import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.common.core.exception.FebsException;
import com.cxf.febs.common.core.utils.FebsUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * 基金分组表 Controller
 *
 * @author sixpence
 * @date 2021-10-18 10:48:17
 */
@Slf4j
@Validated
@RestController
@RequestMapping("group")
@RequiredArgsConstructor
public class GroupController {

    private final IGroupService groupService;

    @GetMapping
    @PreAuthorize("hasAuthority('group:list')")
    public FebsResponse getAllGroups(Group group) {
        return new FebsResponse().data(groupService.findGroups(group));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('group:list')")
    public FebsResponse groupList(QueryRequest request, Group group) {
        Map<String, Object> dataTable = FebsUtil.getDataTable(this.groupService.findGroups(request, group));
        return new FebsResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('group:add')")
    public void addGroup(@Valid Group group) throws FebsException {
        try {
            this.groupService.createGroup(group);
        } catch (Exception e) {
            String message = "新增Group失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('group:delete')")
    public void deleteGroup(Group group) throws FebsException {
        try {
            this.groupService.deleteGroup(group);
        } catch (Exception e) {
            String message = "删除Group失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('group:update')")
    public void updateGroup(Group group) throws FebsException {
        try {
            this.groupService.updateGroup(group);
        } catch (Exception e) {
            String message = "修改Group失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}

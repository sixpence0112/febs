package com.cxf.febs.server.system.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.cxf.febs.common.core.annotation.ControllerEndpoint;
import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.common.core.entity.system.Log;
import com.cxf.febs.common.core.utils.FebsUtil;
import com.cxf.febs.server.system.service.ILogService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * @author sixpence
 * @version 1.0 2021/1/4
 */
@Slf4j
@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private ILogService logService;

    @GetMapping
    public FebsResponse logList(Log log, QueryRequest request) {
        Map<String, Object> dataTable = FebsUtil.getDataTable(this.logService.findLogs(log, request));
        return new FebsResponse().data(dataTable);
    }

    @DeleteMapping("{ids}")
    @PreAuthorize("hasAuthority('log:delete')")
    @ControllerEndpoint(exceptionMessage = "删除日志失败")
    public void deleteLogss(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] logIds = ids.split(StringPool.COMMA);
        this.logService.deleteLogs(logIds);
    }


    @PostMapping("excel")
    @PreAuthorize("hasAuthority('log:export')")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    public void export(QueryRequest request, Log lg, HttpServletResponse response) {
        List<Log> logs = this.logService.findLogs(lg, request).getRecords();
        ExcelKit.$Export(Log.class, response).downXlsx(logs, false);
    }
}

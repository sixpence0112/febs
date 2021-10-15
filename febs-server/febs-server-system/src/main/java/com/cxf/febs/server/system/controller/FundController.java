package com.cxf.febs.server.system.controller;

import com.cxf.febs.server.system.entity.Fund;
import com.cxf.febs.server.system.service.IFundService;
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
 * 基金表 Controller
 *
 * @author sixpence
 * @date 2021-10-15 17:20:13
 */
@Slf4j
@Validated
@RestController
@RequestMapping("fund")
@RequiredArgsConstructor
public class FundController {

    private final IFundService fundService;

    @GetMapping
    @PreAuthorize("hasAuthority('fund:list')")
    public FebsResponse getAllFunds(Fund fund) {
        return new FebsResponse().data(fundService.findFunds(fund));
    }

    @GetMapping("list")
    @PreAuthorize("hasAuthority('fund:list')")
    public FebsResponse fundList(QueryRequest request, Fund fund) {
        Map<String, Object> dataTable = FebsUtil.getDataTable(this.fundService.findFunds(request, fund));
        return new FebsResponse().data(dataTable);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('fund:add')")
    public void addFund(@Valid Fund fund) throws FebsException {
        try {
            this.fundService.createFund(fund);
        } catch (Exception e) {
            String message = "新增Fund失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('fund:delete')")
    public void deleteFund(Fund fund) throws FebsException {
        try {
            this.fundService.deleteFund(fund);
        } catch (Exception e) {
            String message = "删除Fund失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }

    @PutMapping
    @PreAuthorize("hasAuthority('fund:update')")
    public void updateFund(Fund fund) throws FebsException {
        try {
            this.fundService.updateFund(fund);
        } catch (Exception e) {
            String message = "修改Fund失败";
            log.error(message, e);
            throw new FebsException(message);
        }
    }
}

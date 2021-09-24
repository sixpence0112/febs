package com.cxf.febs.gateway.enhance.controller;

import com.cxf.febs.common.core.entity.QueryRequest;
import com.cxf.febs.gateway.enhance.entity.RateLimitLog;
import com.cxf.febs.gateway.enhance.entity.RateLimitRule;
import com.cxf.febs.gateway.enhance.service.RateLimitLogService;
import com.cxf.febs.gateway.enhance.service.RateLimitRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author sixpence
 * @version 1.0 2021/9/24
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("route/auth/rateLimitLog")
public class RateLimitLogController {

    private final RateLimitLogService rateLimitLogService;

    @GetMapping("date")
    public Flux<RateLimitLog> findUserPage(QueryRequest request, RateLimitLog rateLimitLog) {
        return rateLimitLogService.findPages(request, rateLimitLog);
    }

    @GetMapping("count")
    public Mono<Long> findUserCount(RateLimitLog rateLimitLog) {
        return rateLimitLogService.findCount(rateLimitLog);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin')")
    public Flux<RateLimitLog> deleteRateLimitLog(String ids) {
        return rateLimitLogService.delete(ids);
    }
}

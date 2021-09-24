package com.cxf.febs.gateway.enhance.controller;

import com.cxf.febs.common.core.entity.FebsResponse;
import com.cxf.febs.gateway.enhance.auth.JwtTokenHelper;
import com.cxf.febs.gateway.enhance.entity.RouteLog;
import com.cxf.febs.gateway.enhance.service.RouteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author sixpence
 * @version 1.0 2021/9/24
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("route")
public class RouteLoginController {

    private final JwtTokenHelper tokenHelper;
    private final PasswordEncoder passwordEncoder;
    private final RouteUserService routeUserService;

    @GetMapping("login")
    public Mono<ResponseEntity<FebsResponse>> login(String username, String password) {
        String error = "认证失败，用户名或密码错误";
        return routeUserService.findByUsername(username)
                .map(u -> passwordEncoder.matches(password, u.getPassword()) ?
                        ResponseEntity.ok(new FebsResponse().data(tokenHelper.generateToken(u))) :
                        new ResponseEntity<>(new FebsResponse().message(error), HttpStatus.INTERNAL_SERVER_ERROR))
                .defaultIfEmpty(new ResponseEntity<>(new FebsResponse().message(error), HttpStatus.INTERNAL_SERVER_ERROR));
    }
}

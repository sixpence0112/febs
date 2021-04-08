package com.cxf.febs.server.system.controller;

import com.cxf.febs.server.system.entity.Push;
import com.cxf.febs.server.system.properties.FebsServerSystemProperties;
import com.getui.push.v2.sdk.api.AuthApi;
import com.getui.push.v2.sdk.api.PushApi;
import com.getui.push.v2.sdk.api.UserApi;
import com.getui.push.v2.sdk.common.ApiResult;
import com.getui.push.v2.sdk.dto.req.Audience;
import com.getui.push.v2.sdk.dto.req.Settings;
import com.getui.push.v2.sdk.dto.req.Strategy;
import com.getui.push.v2.sdk.dto.req.message.PushDTO;
import com.getui.push.v2.sdk.dto.req.message.PushMessage;
import com.getui.push.v2.sdk.dto.req.message.android.GTNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author sixpence
 * @version 1.0 2021/1/22
 */
@Slf4j
@RestController
@RequestMapping("push")
public class PushController {

    @Autowired
    private PushApi pushApi;
    @Autowired
    private FebsServerSystemProperties properties;

    @PostMapping("test")
    public void send2Single(Push push) {
        log.info(pushApi.toString());
        //根据alias进行单推
        PushDTO<Audience> pushDTO = new PushDTO<Audience>();

        // 设置推送参数
        //请求唯一标识号
        pushDTO.setRequestId(System.currentTimeMillis() + "");
        //消息参数
        PushMessage pushMessage = new PushMessage();
        pushDTO.setPushMessage(pushMessage);
        GTNotification notification = new GTNotification();
        pushMessage.setNotification(notification);
        notification.setTitle(push.getTitle());
        notification.setBody(push.getBody());
        notification.setClickType(push.getClickType());
        notification.setIntent(push.getIntent());
        // 设置接收人信息
        Audience audience = new Audience();
        pushDTO.setAudience(audience);
        audience.addAlias("7951004d01f84f1ba0485eaeef157b32");

        Settings settings = new Settings();
        settings.setTtl(3600000);
        Strategy strategy = new Strategy();
        strategy.setDef(1);
        strategy.setIos(4);
        strategy.setSt(4);
        settings.setStrategy(strategy);
        pushDTO.setSettings(settings);


        // 进行cid单推
        ApiResult<Map<String, Map<String, String>>> apiResult = pushApi.pushToSingleByAlias(pushDTO);
        if (apiResult.isSuccess()) {
            // success
            System.out.println(apiResult.getData());
        } else {
            // failed
            System.out.println("code:" + apiResult.getCode() + ", msg: " + apiResult.getMsg());
        }
    }

}

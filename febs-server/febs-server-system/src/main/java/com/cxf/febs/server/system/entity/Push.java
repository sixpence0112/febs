package com.cxf.febs.server.system.entity;

import lombok.Data;

/**
 * 推送消息实体
 * @author sixpence
 * @version 1.0 2021/1/29
 */
@Data
public class Push {
    /**
     * 点击推送的后续操作
     */
    private String clickType = "intent";
    /**
     * 点击通知打开应用特定页面，长度 ≤ 2048
     */
    private String intent = "intent:#Intent;component=uni.UNIB11CAD0;end";
    /**
     * 推送标题
     */
    private String title = "和推广";
    /**
     * 推送内容
     */
    private String body = "这是一条推送";
    /**
     * 客户端id
     */
    private String cid;
    /**
     * 别名
     */
    private String alias;

}

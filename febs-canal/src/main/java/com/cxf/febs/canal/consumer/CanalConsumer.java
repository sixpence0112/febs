package com.cxf.febs.canal.consumer;

import com.alibaba.fastjson.JSONObject;
import com.cxf.febs.canal.entity.CanalBean;
import com.cxf.febs.canal.entity.TbCommodityInfo;
import com.cxf.febs.common.core.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

/**
 * @author sixpence
 * @version 1.0 2021/6/8
 */
@Slf4j
@Component
public class CanalConsumer {

    private RedisService redisService;

    //redis操作工具类
    //监听的队列名称为：canaltopic
    @KafkaListener(topics = "canaltopic")
    public void receive(ConsumerRecord<?, ?> consumer) {
        String value = (String) consumer.value();
        log.info("topic名称:{},key:{},分区位置:{},下标:{},value:{}", consumer.topic(), consumer.key(),consumer.partition(), consumer.offset(), value);
        //转换为javaBean
        CanalBean canalBean = JSONObject.parseObject(value, CanalBean.class);
        System.out.println(canalBean.toString());
        //获取是否是DDL语句
        boolean isDdl = canalBean.isDdl();
        //获取类型
        String type = canalBean.getType();
        HashSet hashSet = new HashSet();
        //不是DDL语句
        if (!isDdl) {
            List<TbCommodityInfo> tbCommodityInfos = canalBean.getData();
            //过期时间
            long TIME_OUT = 600L;
            if ("INSERT".equals(type)) {
                //新增语句
                for (TbCommodityInfo tbCommodityInfo : tbCommodityInfos) {
                    String id = tbCommodityInfo.getId();
                    //新增到redis中,过期时间是10分钟
                    redisService.set(id, JSONObject.toJSONString(tbCommodityInfo), TIME_OUT);
                }
            } else if ("UPDATE".equals(type)) {
                //更新语句
                for (TbCommodityInfo tbCommodityInfo : tbCommodityInfos) {
                    String id = tbCommodityInfo.getId();
                    //更新到redis中,过期时间是10分钟
                    redisService.set(id, JSONObject.toJSONString(tbCommodityInfo), TIME_OUT);
                }
            } else {
                //删除语句
                for (TbCommodityInfo tbCommodityInfo : tbCommodityInfos) {
                    String id = tbCommodityInfo.getId();
                    //从redis中删除
                    redisService.del(id);
                }
            }
        }
    }
}


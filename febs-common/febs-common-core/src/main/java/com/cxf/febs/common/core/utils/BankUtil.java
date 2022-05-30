package com.cxf.febs.common.core.utils;

import com.xiaoleilu.hutool.http.HttpUtil;
import com.xiaoleilu.hutool.json.JSONObject;
import com.xiaoleilu.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sixpence
 * @version 1.0 2020/11/4
 */
public class BankUtil {

    public static void main(String[] args) throws Exception {
        /*String bankNo = "6217858000100402194";
        //银行代码请求接口 url
        String url = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=" + bankNo + "&cardBinCheck=true";
        //发送请求，得到 josn 类型的字符串
        String result = HttpUtil.get(url);
        System.out.println(result);
        // 转为 Json 对象
        JSONObject json = new JSONObject(result);
        //获取到 bank 代码
        String bank = String.valueOf(json.get("bank"));
        System.out.println(bank);*/


        String jsona = "{\"code\":200,\"message\":\"成功\",\"data\":[{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 13:33:37\",\"syncstate\":\"0\",\"cday\":0,\"channgestate\":\"2\",\"changeid\":\"202203251333377282\",\"haveCardType\":\"4\",\"outorderid\":\"58abd68a2c494a7b88c3b3d2d91e9c97\",\"ordertype\":\"80\"},{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 13:33:55\",\"syncstate\":\"0\",\"cday\":0,\"channgestate\":\"2\",\"changeid\":\"202203251333558777\",\"haveCardType\":\"4\",\"outorderid\":\"737f690a7508400d80e19b2bb059f38a\",\"ordertype\":\"80\"},{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 15:38:34\",\"syncstate\":\"0\",\"syncMsg\":\"15736700657\",\"cday\":0,\"channgestate\":\"6\",\"changeid\":\"202203251538345261\",\"haveCardType\":\"2\",\"outorderid\":\"aa11fb6276514dbab0691396ae09e6ef\",\"ordertype\":\"80\"},{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 15:47:20\",\"syncstate\":\"0\",\"syncMsg\":\"18768862518\",\"cday\":0,\"channgestate\":\"6\",\"changeid\":\"202203251547203034\",\"haveCardType\":\"2\",\"outorderid\":\"02f615c4ec284f349c910bea8b10921d\",\"ordertype\":\"80\"},{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 15:49:07\",\"syncstate\":\"0\",\"cday\":0,\"channgestate\":\"2\",\"changeid\":\"202203251549073557\",\"haveCardType\":\"4\",\"outorderid\":\"93819c2d8bba4d0f9f7f20f2f0375311\",\"ordertype\":\"80\"},{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 15:55:25\",\"syncstate\":\"0\",\"syncMsg\":\"13838209965\",\"cday\":0,\"channgestate\":\"6\",\"changeid\":\"202203251555256706\",\"haveCardType\":\"2\",\"outorderid\":\"07bdfb11c20d4841a69270c71649e897\",\"ordertype\":\"80\"},{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 16:13:53\",\"syncstate\":\"0\",\"syncMsg\":\"15237168212\",\"cday\":0,\"channgestate\":\"6\",\"changeid\":\"202203251613533647\",\"haveCardType\":\"2\",\"outorderid\":\"e72106b677884fb58c72e24a12ca3eb8\",\"ordertype\":\"80\"},{\"wlOrderid\":\"JDV006206531732\",\"accessId\":\"1036\",\"changetime\":\"2022-03-25 16:59:47\",\"syncstate\":\"0\",\"syncMsg\":\"\",\"wlCompany\":\"京东快递\",\"cday\":0,\"channgestate\":\"3\",\"changeid\":\"202203251659479611\",\"haveCardType\":\"4\",\"outorderid\":\"93819c2d8bba4d0f9f7f20f2f0375311\",\"ordertype\":\"80\"},{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 17:10:00\",\"syncstate\":\"0\",\"cday\":0,\"channgestate\":\"2\",\"changeid\":\"202203251710005862\",\"haveCardType\":\"4\",\"outorderid\":\"fe5b8a62f0254548936ef4e29cb96eba\",\"ordertype\":\"80\"},{\"accessId\":\"1036\",\"changetime\":\"2022-03-25 17:15:53\",\"syncstate\":\"0\",\"cday\":0,\"channgestate\":\"2\",\"changeid\":\"202203251715533137\",\"haveCardType\":\"4\",\"outorderid\":\"341532f821f9496e865fc6ffff9cf1d3\",\"ordertype\":\"80\"},{\"wlOrderid\":\"JDV006207834472\",\"accessId\":\"1036\",\"changetime\":\"2022-03-25 18:58:50\",\"syncstate\":\"0\",\"syncMsg\":\"\",\"wlCompany\":\"京东快递\",\"cday\":0,\"channgestate\":\"3\",\"changeid\":\"202203251858502088\",\"haveCardType\":\"4\",\"outorderid\":\"341532f821f9496e865fc6ffff9cf1d3\",\"ordertype\":\"80\"},{\"wlOrderid\":\"JDV006207735455\",\"accessId\":\"1036\",\"changetime\":\"2022-03-25 19:09:14\",\"syncstate\":\"0\",\"syncMsg\":\"\",\"wlCompany\":\"京东快递\",\"cday\":0,\"channgestate\":\"3\",\"changeid\":\"202203251909147299\",\"haveCardType\":\"4\",\"outorderid\":\"fe5b8a62f0254548936ef4e29cb96eba\",\"ordertype\":\"80\"}]}";
        ;
        System.out.println(json2Map(JSONUtil.parseObj(jsona)));
    }

    public static Map<String, String> json2Map(JSONObject json) {

        /*return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));*/
        return null;
    }
}

package com.cxf.febs.common.core.utils;

import com.xiaoleilu.hutool.http.HttpUtil;
import com.xiaoleilu.hutool.json.JSONObject;

/**
 * @author sixpence
 * @version 1.0 2020/11/4
 */
public class BankUtil {

    public static void main(String[] args) throws Exception {
        String bankNo = "6217858000100402194";
        //银行代码请求接口 url
        String url = "https://ccdcapi.alipay.com/validateAndCacheCardInfo.json?_input_charset=utf-8&cardNo=" + bankNo + "&cardBinCheck=true";
        //发送请求，得到 josn 类型的字符串
        String result = HttpUtil.get(url);
        System.out.println(result);
        // 转为 Json 对象
        JSONObject json = new JSONObject(result);
        //获取到 bank 代码
        String bank = String.valueOf(json.get("bank"));
        System.out.println(bank);
    }
}

package com.cxf.febs.common.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sixpence
 * @version 1.0 2021/9/28
 */
public class RegUtil {


    public static void main(String args[]) {

        String aa = "1[\\d?=4]{8}(6|7|8|9)\\1{1}";
        String str = "12456187888";
        String pattern = "^((1[2-6])|(2[13-6])|(3[124-6])|(4[1-356])|(5[1-46])|(6[1-5]))$";
        String pattern1 = "^1[\\d?=4]{8}((1[2-])|(2[13-6])|(3[124-6])|(4[1-356])|(5[1-46])|(6[1-5]))(6|7|8|9)\\1{1}$";

        String pa = "^1[\\d]{6}78([6-9])\\1{1}(?=4)$";

        Pattern r = Pattern.compile(pa);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

}

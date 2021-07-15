package com.cxf.febs.common.core.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author sixpence
 * @version 1.0 2021/7/12
 */
public class AesUtil {

    public static void test() throws Exception {
        String value = "mrbird's blog";
        System.out.println("待加密值：" + value);
        // 加密算法
        String algorithm = "AES";
        // 转换模式
        String transformation = "AES";
        // --- 生成秘钥 ---
        // 实例化秘钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        // 初始化秘钥长度
        keyGenerator.init(256);
        // 生成秘钥
        SecretKey secretKey = keyGenerator.generateKey();
        // 生成秘钥材料
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), algorithm);
        System.out.println("AES秘钥：" + java.util.Base64.getEncoder().encodeToString(secretKey.getEncoded()));

        // 实例化密码对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 设置模式（ENCRYPT_MODE：加密模式；DECRYPT_MODE：解密模式）和指定秘钥
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // 加密
        byte[] encrypt = cipher.doFinal(value.getBytes());
        System.out.println("AES加密结果：" + java.util.Base64.getEncoder().encodeToString(encrypt));
        // 解密
        // 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("AES解密结果：" + new String(decrypt));
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}

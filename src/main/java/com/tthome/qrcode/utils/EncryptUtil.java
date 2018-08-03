package com.tthome.qrcode.utils;

import java.util.Base64;
import java.util.UUID;

public class EncryptUtil {
    /***
     * Base64加密
     * @param str 需要加密的参数
     * @return
     * @throws Exception
     */
    public static String encrypt_Base64(String str) throws Exception {
        String result = Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
        return result;
    }
    /***
     * Base64解密
     * @param str 需要解密的参数
     * @return
     * @throws Exception
     */
    public static String decrypt_Base64(String str) throws Exception {
        byte[] asBytes = Base64.getDecoder().decode(str);
        String result = new String(asBytes,"UTF-8");
        return result;
    }

    public static void main(String[] args) throws Exception{

        //随机字符串
        String str = UUID.randomUUID().toString().replace("-", "").substring(0, 20)+String.valueOf(System.currentTimeMillis());
        String s = encrypt_Base64(str);
        System.out.println(str);
        System.out.println(s);
        System.out.println(s.length());


    }
}

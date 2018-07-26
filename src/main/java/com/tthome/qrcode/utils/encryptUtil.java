package com.tthome.qrcode.utils;

import com.tthome.qrcode.entity.CheckData;

import java.util.Base64;
import java.util.UUID;

public class encryptUtil {
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
    /*    String string="aaaaaa9383";
        String str = UUID.randomUUID().toString().replace("-", "").substring(0, 20);
        long l = System.currentTimeMillis();
        String s = String.valueOf(l)+string;
        System.out.println(s.hashCode());
        System.out.println(s);
        System.out.println(str);*/
        String str = UUID.randomUUID().toString().replace("-", "").substring(0, 20);
        CheckData checkData1=new CheckData(1,"ssssss",1);

        CheckData checkData2=new CheckData(2,"123",1);

        CheckData checkData3=new CheckData(3,"88888",1);

         String aa=checkData3.getHashcode()+str;
       /* CheckData checkData4=new CheckData(3,aa.hashCode()+"",1);*/
        String base64 = encrypt_Base64(aa);
        System.out.println(decrypt_Base64(base64));


    }
}

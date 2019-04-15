package com.ming.ljs.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * created by ZMX
 * Date 2019/4/14 Time 20:56
 */
public class MD5Utils {

    public static String getMD5(String password,int salt){
        String md5hashValue="";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            byte[] digest1 = digest.digest(password.getBytes());
            for (byte b : digest1) {
                int i = b&0x000000FF;
                String s = Integer.toHexString(i+salt);
                if(s.length() == 1){
                    stringBuffer.append("0");
                }
                stringBuffer.append(s);
            }
            md5hashValue = stringBuffer.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5hashValue;
    }
}

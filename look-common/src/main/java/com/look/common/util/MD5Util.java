package com.look.common.util;

import java.security.MessageDigest;

public class MD5Util {

    //创建MD5算法的信息摘要
    public static String digestMD5(String pwd){
        StringBuffer hexValue = new StringBuffer();
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            char[] charArray = pwd.toCharArray();
            byte[] byteArray = new byte[charArray.length];

            for (int i = 0; i < charArray.length; i++){
                byteArray[i] = (byte) charArray[i];
            }
            byte[] md5Bytes = md5.digest(byteArray);
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return hexValue.toString();
    }

}

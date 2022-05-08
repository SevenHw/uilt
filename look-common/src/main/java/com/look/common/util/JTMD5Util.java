package com.look.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

public class JTMD5Util {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static String md5(String[] param, String code) {
        Arrays.sort(param);
        System.out.println(Arrays.toString(param));
        byte[] hash;
        try {
            hash = MessageDigest.getInstance(code).digest(Arrays.toString(param).getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 is unsupported", e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e);
        }
        StringBuilder hex = new StringBuilder(hash.length * 2);
        if("SHA".equals(code)) {
            for (int i = 0; i < hash.length; i++) {
                int val = ((int) hash[i]) & 0xff;
                if (val < 16) {
                    hex.append("0");
                }
                hex.append(Integer.toHexString(val));
            }
        }else {
            for (byte b : hash) {
                if ((b & 0xFF) < 0x10) hex.append("0");
                hex.append(Integer.toHexString(b & 0xFF));
            }
        }
        return hex.toString();
    }


    /**
     * 请求参数签名验证
     * @return true 验证通过 false 验证失败
     * @throws Exception
     */
    public static boolean verifySign(String sign, String[] params) throws Exception {
        if(StringUtils.isBlank(sign)){
            throw new RuntimeException("There is no signature field in the request parameter!");
        }
        if (!StringUtils.equals(generateSignatureMD5(params),sign)) {
            return false;
        }
        return true;
    }

    public static String generateSignatureMD5(String [] params) throws Exception {
        return md5(params,"MD5");
    }

    public static String generateSignatureSHA(String [] params) throws Exception {
        return md5(params,"SHA");
    }

    public static void main(String[] args) {
        try {
            JSONObject message = new JSONObject();
            String time = String.valueOf(new Date().getTime());
            String code = String.valueOf((int)(Math.random()*900)+100);
            File jsonFile = ResourceUtils.getFile("classpath:data1.json");
            String json = FileUtils.readFileToString(jsonFile);
            JSONObject jsonObject = JSONObject.parseObject(json);
            String[] params6 = { "UJMJPXLPNHZF4VN07L9K", "RPM8YXC7SK", "1604296225341", "939",
                    jsonObject.get("content").toString() };
            String sign = JTMD5Util.generateSignatureMD5(params6);
            System.out.println(sign);
            message.put("appid","UlBNOFlYQzdTSw==");
            message.put("time",time);
            message.put("sign",sign);
            message.put("code",code);
            message.put("content",json);
            System.out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

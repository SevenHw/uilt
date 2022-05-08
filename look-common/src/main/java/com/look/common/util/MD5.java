/**
 * 文件名: MD5.java
 * 版    权: Copyright © 2013 - 2017 CFNE, Inc. All Rights Reserved
 * 描    述: &lt;描述&gt;
 * 修改人: Jiao.Chen
 * 修改时间: 2017/12/1
 * 跟踪单号: &lt;跟踪单号&gt;
 * 修改单号: &lt;修改单号&gt;
 * 修改内容: &lt;修改内容&gt;
 */
package com.look.common.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

public class MD5
{

    /**
     * 访问REST服务
     * @param url
     * @param txt
     * @return
     * @throws Exception
     */
    public static String loadREST(String url,String txt) throws Exception
    {
        String line,resultStr="";
        URL restURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type","application/json;charset=UTF-8");
        conn.setDoOutput(true);
        conn.setAllowUserInteraction(false);
        PrintStream ps = new PrintStream(conn.getOutputStream());
        String postinfo=txt;
        ps.print(postinfo);
        InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream(), "utf-8");
        BufferedReader bReader = new BufferedReader(inputStreamReader);
        while(null != (line=bReader.readLine()))

        {

            resultStr +=line;

        }

        bReader.close();
        ps.close();

        return resultStr;
        }

    public static String getMD5(String txt) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(txt.getBytes("UTF-8"));
            byte[] bPwd = md.digest();
            String pwd = new BigInteger(1, bPwd).toString(16);
            if (pwd.length() % 2 == 1) {
                pwd = "0" + pwd;
            }
            int length = pwd.length();
            StringBuffer sb = new StringBuffer(length + length / 2 - 1);
            for (int i = 0; i < length; i += 2) {
                sb.append(pwd.substring(i, i + 2));
            }
            return sb.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return txt;
    }
}

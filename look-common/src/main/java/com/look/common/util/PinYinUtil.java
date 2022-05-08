package com.look.common.util;

import com.alibaba.fastjson.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;


public class PinYinUtil {


    // 返回中文的首字母
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }
    /**
     * 提取每个汉字的首字母
     *
     * @param str
     * @return String
     */
    public static String getFirstPinYin(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            // 提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
//        String reg = "[^A-Z]+";
        return convert.toUpperCase();
    }
    //先把key转为小写，按首字母排序，然后MD5加密，在转小写
    public static String getSortJsones(JSONObject json)
    {
        Iterator<String> iteratorKeys = json.keySet().iterator();
        SortedMap map = new TreeMap();
        while (iteratorKeys.hasNext())
        {
            String key = iteratorKeys.next();
            String vlaue = json.getString(key);
            map.put(key.toLowerCase(), vlaue);
        }
        String res="";
        for (Object value : map.values()) {
            res+=null!=value?value.toString():null;
        }
        res+="ztooaxcx~!@#$?";
        res=res.replace(" ", "");
         String contrast = MD5Util.digestMD5(res);
        String contrastTop = contrast.toLowerCase();
        return contrastTop;
    }

    //先把key转为小写，按首字母排序，然后MD5加密，在转小写
    public static String getSortJson(JSONObject json)
    {
        Iterator<String> iteratorKeys = json.keySet().iterator();
        SortedMap map = new TreeMap();
        while (iteratorKeys.hasNext())
        {
            String key = iteratorKeys.next().toString();
            String vlaue = json.getString(key);
            map.put(key.toLowerCase(), vlaue);
        }
        JSONObject jsonObject = new JSONObject(map);
        String contrast = MD5Util.digestMD5(String.valueOf(jsonObject));
        String contrastTop = contrast.toLowerCase();
        return contrastTop;
    }
//        public static void main(String[] args){
//            JSONObject json = new JSONObject();
//            json.put("ids", "第二位/");
//            json.put("encryDate", "调5度/");
//            json.put("bVf", "第一位/");
//            json.put("eDee", "调3度/");
//            json.put("edf", "调4度/");
    //        json.put("edfg", "333");
//            System.out.println(getSortJson(json));
//        }
//public static void main(String[] args) throws JSONException {
//    JSONObject jsonObject = new JSONObject();
//    jsonObject.put("xg",1233);
//    jsonObject.put("pg","kkk");
//    Iterator<String> iteratorKeys = jsonObject.keySet().iterator();
//    while (iteratorKeys.hasNext()) {
//        String key = iteratorKeys.next();
//        String vlaue = jsonObject.getString(key).toString();
//       System.out.println(key);
//        System.out.println("++++"+vlaue);
//
//    }
//
//}
}

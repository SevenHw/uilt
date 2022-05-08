package com.look.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 功能描述 :
 * 递归遍历json工具类
 * @author Qi.Wang
 * @version [版本号,  2022/1/12]
 * @see [相关类/方法]
 * @date 2022/1/12
 * @since [产品/模板版本号]
 */
public class AlgoriThmSigneUtil {

    //test
//    public static void main(String[] args) throws Exception {
//        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = new JSONArray();
//        JSONObject jsonObject1 = new JSONObject();
//        jsonObject1.put("zzz","1");
//        jsonObject1.put("ss","2");
//        jsonObject1.put("e","3");
//        jsonArray.add(jsonObject1);
//        jsonObject.put("we","2");
//        jsonObject.put("sf","");
//        jsonObject.put("list",jsonArray);
//        jsonObject.put("a","re");
//        System.out.println(MD5Util.digestMD5(recursiveTraversal(jsonObject,new StringBuilder())));
//    }

    /***
     * 递归遍历json
     * @param jsonObject
     * @param stringBuilder
     * @return
     * @throws Exception
     */
    public static   String  recursiveTraversal(JSONObject jsonObject,StringBuilder stringBuilder) throws Exception {
        Iterator<?> iterator = getSortJson(jsonObject).keySet().iterator();
        while (iterator.hasNext()){
            String key=iterator.next().toString();
            String value=jsonObject.getString(key);
            if (isJsonObj(value)) {
                stringBuilder = stringBuilder.append(key+"=");
                recursiveTraversal(JSONObject.parseObject(value), stringBuilder);

            }else if (isJsonArryObj(value)){
                stringBuilder = stringBuilder.append(key+"=");
                JSONArray jsonArray=JSONArray.parseArray(value);
                for (int i = 0 ; i< jsonArray.size();i++){
                    recursiveTraversal(jsonArray.getJSONObject(i),stringBuilder);
                }
            }else if (!"signature".equals(key)){
                if ("".equals(jsonObject.getString(key))){
                    stringBuilder.append(key).append("=").append("&");

                }else {
                    stringBuilder.append(key).append("=").append(jsonObject.get(key)+"&");
                }

            }
        }
        String aa=stringBuilder.substring(0,stringBuilder.length()-1);
        return aa;
    }


    /**
     * 递归json排序
     * @param jsonObject
     * @return
     */
    public static JSONObject generateSignatureJson(JSONObject jsonObject) {
        Iterator<?> it = (Iterator<?>) getSortJson(jsonObject).keySet();
        while (it.hasNext()) {
            String key = it.next().toString();
            Object value = jsonObject.get(key);
            if (isJsonObj(value)) {
                jsonObject.put(key,getSortJson(generateSignatureJson(JSONObject.parseObject((String) value))));
            }else if (isJsonArryObj(value)){
                JSONArray jsonArray=JSONArray.parseArray((String) value);
                JSONArray jsonArray1 = new JSONArray();
                for (int i = 0 ; i< jsonArray.size();i++){
                    JSONObject jsonObject1 = getSortJson(generateSignatureJson(JSONObject.parseObject((String) jsonArray.get(i))));
                    jsonArray1.add(jsonObject1);
                }
                jsonObject.put(key,jsonArray1);
            }else {

            }
        }

        return  getSortJson(jsonObject);
    }


    /**
     * json排序
     * @param json
     * @return
     */
    public static JSONObject getSortJson(JSONObject json) {
        Iterator<String> iteratorKeys =  json.keySet().iterator();
        SortedMap map = new TreeMap();
        while (iteratorKeys.hasNext()) {
            String key = iteratorKeys.next().toString();
            Object vlaue = json.get(key);
            map.put(key, vlaue);
        }
        //map转json
        JSONObject json2 = new JSONObject(map);
        return json2;
    }

    /**
     * 判断对象是否是JSONArray
     * @param value
     * @return
     */
    private static boolean isJsonArryObj(Object value) {
        try {
            if ("".equals(value)){
                return false;
            }
            JSON.parseArray(String.valueOf(value));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 判断对象是否是JSONObject
     * @param value
     * @return
     */
    private static boolean isJsonObj(Object value) {
        try {
            if ("".equals(value)){
                return false;
            }
            JSONArray.parseObject(String.valueOf(value));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

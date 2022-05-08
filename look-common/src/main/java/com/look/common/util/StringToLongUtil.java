package com.look.common.util;

/**
 * @ClassName StringToLongUtil
 * @Author like
 * @Date 2022/5/8 16:27
 **/
public class StringToLongUtil {
    /**校验String能否转化为Long*/
    public static boolean isValidLong(String str){
        try{
            long a = Long.parseLong(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}

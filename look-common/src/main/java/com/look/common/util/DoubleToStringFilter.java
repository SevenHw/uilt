package com.look.common.util;

import com.alibaba.fastjson.serializer.ValueFilter;

import java.math.BigDecimal;

/**
 * <p>功能描述：</p>
 *  FastJson double转String filter
 *  处理double值为科学计数法后的值，转换的后的String也为科学计数法
 *
 * @author longguiyun
 * @version 1.0
 * @date 2018/11/22 19:07
 */
public class DoubleToStringFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        if(null != value && value instanceof Double) {
            BigDecimal b = BigDecimal.valueOf((Double) value);
            return  b.longValue();
        }
        return value;
    }
}

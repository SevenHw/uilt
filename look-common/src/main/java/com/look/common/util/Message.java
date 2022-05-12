package com.look.common.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName Message
 * @Author like
 * @Date 2022/5/9 21:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    /**
     * 响应状态码，约定200成功，失败500
     **/
    private Integer code;
    /**
     * 代表响应信息
     **/
    private String msg;
    private Map<String, Object> info=new HashMap<>();
    public static Message success() {
        Message message=new Message();
        message.setCode(200);
        message.setMsg("成功");
        return message;
    }
    public static Message fail() {
        Message message=new Message();
        message.setCode(500);
        message.setMsg("失败");
        return message;
    }
    public Message addInfo(String key,Object value) {
        getInfo().put(key, value);
        return this;
    }
}

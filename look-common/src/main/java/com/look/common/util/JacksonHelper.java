package com.look.common.util;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;


/**
 * toJSON&fromJSON
 * 
 */
public class JacksonHelper implements Serializable {

    private static final long   serialVersionUID = 977280939870035869L;
    private static ObjectMapper toJSONMapper     = new ObjectMapper();
    private static ObjectMapper fromJSONMapper   = new ObjectMapper();
    static {
        fromJSONMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJSON(Object obj) {
        ObjectMapper mapper = toJSONMapper;
        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, obj);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }

    public static void toJSON(Object obj, OutputStream stream, String charset) {
        ObjectMapper mapper = toJSONMapper;
        try {
            OutputStreamWriter writer = new OutputStreamWriter(stream, charset);
            mapper.writeValue(writer, obj);
        } catch (JsonGenerationException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJSON(String json, Class<T> clazz) {
        ObjectMapper mapper = fromJSONMapper;
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJSON(InputStream json, Class<T> clazz) {
        ObjectMapper mapper = fromJSONMapper;
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String getJsonResult(boolean bool, String serverCode, String reason, String resultInfo) {
    	BaseResult res = new BaseResult();
    	res.setResult(bool);
		res.setReason(reason);
        res.setResultCode(serverCode);
        res.setResultInfo(resultInfo);
        return JacksonHelper.toJSON(res);
	}

}

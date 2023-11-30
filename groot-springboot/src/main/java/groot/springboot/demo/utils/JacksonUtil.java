package groot.springboot.demo.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.JsonParseException;

import java.util.List;

/**
 * @author: GuoBen~
 * @date: 2023/4/18 17:33
 * @description:
 */
public class JacksonUtil {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**MAPPER
     * LocalDateTime 时间序列化 反序列化
     */
    static {
        JavaTimeModule timeModule = new JavaTimeModule();
        MAPPER.registerModule(timeModule);

    }

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     *
     * @param data
     * @return
     */
    public static String objectToJson(Object data) throws JsonParseException {
        if (data == null) {
            return null;
        }
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new JsonParseException("Jackson 解析失败:", e);
        } catch (Exception e) {
            throw new JsonParseException("Jackson 解析失败:", e);
        }
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) throws JsonProcessingException {
        T t = MAPPER.readValue(jsonData, beanType);
        return t;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, TypeReference<T> valueTypeRef) {
        try {
            T t = MAPPER.readValue(jsonData, valueTypeRef);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     *
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            List<T> list = MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}

package groot.springboot.demo.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author jiangjk
 */
@Accessors(chain = true)
@Getter
@Setter
public class R<T> implements Serializable {

    private static final long serialVersionUID = -6952078026617941260L;
    /**
     * 响应码
     */
    private String bizCode;
    /**
     * 响应消息
     */
    private String bizDesc;

    /**
     * 响应数据
     */
    private T data;


    public static <T> R<T> ok() {
        return mergeResult(null, "200", null);
    }

    public static <T> R<T> ok(T data) {
        return mergeResult(data, "200", null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return mergeResult(data, "200", msg);
    }

    public static <T> R<T> failed() {
        return mergeResult(null, "5000", null);
    }

    public static <T> R<T> failed(String msg) {
        return mergeResult(null, "5000", msg);
    }

    public static <T> R<T> failed(String errorCode, String msg) {
        return mergeResult(null, errorCode, msg);
    }

    public static <T> R<T> failed(T data) {
        return mergeResult(data, "5000", null);
    }

    public static <T> R<T> failed(T data, String msg) {
        return mergeResult(data, "5000", msg);
    }


    private static <T> R<T> mergeResult(T data, String resCode, String resMsg) {
        R<T> ret = new R<>();
        ret.setBizCode(resCode);
        ret.setData(data);
        ret.setBizDesc(resMsg);
        return ret;
    }

    public String toJsonStr() {
        return JSONObject.toJSONString(this);
    }

}

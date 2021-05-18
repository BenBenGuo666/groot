package groot.springboot.demo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author guox
 * @date 2018/8/27 15:54
 * @description 统一请求响应结果
 */
@Data
@Builder
public class LogicResult<T> implements Serializable {

    private static final long serialVersionUID = 7528399821967501327L;

    /**
     * 成功
     */
    public static final String SUCCESS_CODE = "1";

    /**
     * 失败
     */
    public static final String FAIL_CODE = "0";

    /**
     * 异常
     */
    public static final String ERROR_CODE = "-1";

    /**
     * 未登录
     */
    public static final String NO_LOGIN_CODE = "-2";

    /**
     * 未授权
     */
    public static final String UN_AUTHORIZED = "-3";

    /**
     * 响应码
     */
    @Builder.Default
    private String code = LogicResult.FAIL_CODE;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 处理是否成功
     */
    private boolean success;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 配合 @Builder 使用
     */
    @Tolerate
    public LogicResult() {}

    /**
     * 成功结果响应
     */
    public LogicResult<T> complete() {
        this.success = true;
        this.code = SUCCESS_CODE;
        return this;
    }

    /**
     * 成功结果响应
     *
     * @param data
     */
    public LogicResult<T> complete(T data) {
        this.success = true;
        this.code = SUCCESS_CODE;
        this.data = data;
        return this;
    }

    /**
     * 失败结果响应
     *
     * @param failMsg
     */
    public LogicResult<T> fail(String failMsg) {
        this.success = false;
        this.code = FAIL_CODE;
        this.message = StringUtils.isEmpty(failMsg) ? "请求处理失败!" : failMsg;
        return this;
    }

    /**
     * 异常结果响应
     *
     * @param errorMsg
     */
    public LogicResult<T> error(String errorMsg) {
        this.success = false;
        this.code = ERROR_CODE;
        this.message = StringUtils.isEmpty(errorMsg) ? "请求处理异常!" : errorMsg;
        return this;
    }

    /**
     * 未登录响应
     */
    public LogicResult<T> noLogin(T... redirectUrl) {
        this.success = false;
        this.code = NO_LOGIN_CODE;
        this.message = "登录超时或尚未登录";
        this.data = redirectUrl != null && redirectUrl.length == 1 ? redirectUrl[0] : null;
        return this;
    }

    /**
     * 未授权返回
     */
    public LogicResult<T> unauthorized() {
        this.success = false;
        this.code = UN_AUTHORIZED;
        this.message = "您无权访问该资源，请联系管理员";
        return this;
    }

    /**
     * 异常结果响应
     */
//    public String toJsonString() {
//        return Jsono.toJSon(this);
//    }
}

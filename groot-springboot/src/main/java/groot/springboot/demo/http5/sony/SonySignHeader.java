package groot.springboot.demo.http5.sony;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 17:53
 * @description:
 */
@Getter
@Builder
@JsonPropertyOrder(alphabetic = true)
public class SonySignHeader {

    /**
     * 合作厂商 Id，索尼提供一个固定的值
     * 是
     */
    private String vendorId;

    /**
     * 客户端的 app 的版本
     * 是
     */
    private String appVersion;

    /**
     * 客户端 ip 地址
     * 否
     */
    private String clientIp;

    /**
     * 国际移动设备识别码
     * 否
     */
    private String imei;

    /**
     * 国际移动用户识别码
     * 否
     */
    private String imsi;

    /**
     * 手机制造商
     * 否
     */
    private String manufacture;

    /**
     * 手机型号
     * 否
     */
    private String mode;

    /**
     * 用户 id
     * 否
     */
    private String userId;

    /**
     * 返回参数。响应时返回原值。
     * 是
     */
    private String callbackPara;

    /**
     * 随机序列号，每次请求应唯一
     * 是
     */
    private String nonce;

    /**
     * 客户端操作系统版本
     * 否
     */
    private String osVersion;

    /**
     * 当前北京时间戳，精确到毫秒。超出一定范围则认为非法请求
     * 是
     */
    private long timestamp;


}

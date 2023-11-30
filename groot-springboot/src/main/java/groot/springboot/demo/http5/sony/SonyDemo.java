package groot.springboot.demo.http5.sony;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import groot.springboot.demo.utils.JacksonUtil;
import groot.springboot.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 15:35
 * @description:
 */
@Slf4j
public class SonyDemo {

    private static String API_DOMAIN = "http://musichub.hwtest.sonyselect.com.cn";
    private static String AUTH_DOMAIN = "http://connect-test.sonyselect.cn";

    private static String REDIRECT_URI = "https://connect-test.sonyselect.cn/oauth/F18475FFD9C/code";

    private static String API_VERSION = "v1";

    /**
     * 合作厂商 Id，索尼提供一个固定的值
     */
    private static String VENDOR_ID = "4CDD2C22849";

    private static String SECURITY_KEY = "66B7E655C147337124B377C4A3EF4365E554E2FD8693EC2D5BBE169A261E0FEF";

    private static String CLIENT_ID = "F18475FFD9C";

    private static String CLIENT_SECURITY_KEY = "mYC9Af9VT46XhpuFqGKivEkkvuwIwEz7";

    private static String SIGN_ALGORITHM = "HmacSHA256";

    public static void main(String[] args) {
        String uri = "/resource/full_sync_id/v1";
        String data = "{'pageNo':0,'pageSize':100,'type':'column'}";
        String data2 = "{'body':{'pageNo':0,'pageSize':100,'type':'column'}," +
                "'header':{'appVersion':'abc','clientIp':'abc','imei':'abc'," +
                "'imsi':'abc','manufacture':'abc','mode':'abc','userId':'45821'," +
                "'callbackPara':'mycallback','nonce':'1011804155','osVersion':'abc'," +
                "'timestamp':1688975903559,'vendorId':'4CDD2C22849'}}";
        String data3 = "{'body':{'pageNo':0,'pageSize':100,'type':'column'}," +
                "'header':{'appVersion':'abc','clientIp':'abc','imei':'abc','imsi':'abc'," +
                "'manufacture':'abc','mode':'abc','userId':'45821','callbackPara':'mycallback'," +
                "'nonce':'1267163997','osVersion':'abc','timestamp':1688981062649,'vendorId':'4CDD2C22849'}}";
        String data4 = "{'body':{'pageNo':0,'pageSize':100,'type':'column'}}";
        String data5 = "{\"body\":{\"pageNo\":0,\"pageSize\":100,\"type\":\"column\"},\"header\":{\"appVersion\":\"abc\",\"clientIp\":\"abc\",\"imei\":\"abc\",\"imsi\":\"abc\",\"manufacture\":\"abc\",\"mode\":\"abc\",\"userId\":\"45821\",\"callbackPara\":\"mycallback\",\"nonce\":\"1267163997\",\"osVersion\":\"abc\",\"timestamp\":1688981062649,\"vendorId\":\"4CDD2C22849\"}}";
        String type = "column";

        SonySignBody sonySignBody = SonySignBody.builder()
                .pageNo(0).pageSize(100).type(type).build();

        SonySignHeader sonySignHeader = SonySignHeader.builder()
                .appVersion("abc").clientIp("abc").imei("abc").imsi("abc")
                .manufacture("abc").mode("abc").userId("45821").callbackPara("mycallback")
                .nonce("1267163997").osVersion("abc").timestamp(1688981062649L).vendorId("4CDD2C22849").build();
        SonySign sonySigns = SonySign.builder().body(sonySignBody).header(sonySignHeader).build();

        Map map = JsonUtils.gsonToObj(data5, TreeMap.class);
        data += uri;
        data2 += uri;
        data3 += uri;
        data4 += uri;
        data5 += uri;
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(data5);
        String nonce = "1011804155";
        long timestamp = 1688975903559L;
        String nonce2 = "1267163997";
        long timestamp2 = 1688981062649L;
        String mySign = sign(data, SECURITY_KEY + nonce + timestamp);
        String sonySign = hmacsha256(data, SECURITY_KEY + nonce + timestamp);
        System.out.println(mySign);
        System.out.println(sonySign);
        System.out.println(mySign.equals(sonySign));
        String mySign2 = sign(data2, SECURITY_KEY + nonce + timestamp);
        String sonySign2 = hmacsha256(data2, SECURITY_KEY + nonce + timestamp);
        System.out.println(mySign2);
        System.out.println(sonySign2);
        System.out.println(mySign2.equals(sonySign2));
        String mySign3 = sign(data3, SECURITY_KEY + nonce2 + timestamp2);
        String sonySign3 = hmacsha256(data3, SECURITY_KEY + nonce2 + timestamp2);
        System.out.println(mySign3);
        System.out.println(sonySign3);
        System.out.println(mySign3.equals(sonySign3));
        String mySign4 = sign(data4, SECURITY_KEY + nonce2 + timestamp2);
        String sonySign4 = hmacsha256(data4, SECURITY_KEY + nonce2 + timestamp2);
        System.out.println(mySign4);
        System.out.println(sonySign4);
        System.out.println(mySign4.equals(sonySign4));
        String mySign5 = sign(data5, SECURITY_KEY + nonce2 + timestamp2);
        String sonySign5 = hmacsha256(data5, SECURITY_KEY + nonce2 + timestamp2);
        System.out.println(mySign5);
        System.out.println(sonySign5);
        System.out.println(mySign5.equals(sonySign5));
        System.out.println("d45767d54d9d8efc774a242dcfe8a1c2e7fd74dfbbeacca35e8753c332ae6bef".equals(sonySign5));
        String mapStr = JsonUtils.toGson(map);
//        System.out.println("mapStr->" + mapStr);
        String mySign6 = sign(mapStr + uri, SECURITY_KEY + nonce2 + timestamp2);
        String sonySign6 = hmacsha256(mapStr + uri, SECURITY_KEY + nonce2 + timestamp2);
        System.out.println(mySign6);
        System.out.println(sonySign6);
        System.out.println(mySign6.equals(sonySign6));
        System.out.println("d45767d54d9d8efc774a242dcfe8a1c2e7fd74dfbbeacca35e8753c332ae6bef".equals(sonySign6));
        String jsonStr = JacksonUtil.objectToJson(sonySigns);
        System.out.println("jsonStr:" + jsonStr);
        String mySign7 = sign(jsonStr + uri, SECURITY_KEY + nonce2 + timestamp2);
        String sonySign7 = hmacsha256(jsonStr + uri, SECURITY_KEY + nonce2 + timestamp2);
        System.out.println(mySign7);
        System.out.println(sonySign7);
        System.out.println(mySign7.equals(sonySign7));
        System.out.println("d45767d54d9d8efc774a242dcfe8a1c2e7fd74dfbbeacca35e8753c332ae6bef".equals(mySign7));
    }

    /**
     * @param plainStr 需要加密的字符串
     * @param key      key = AppSecret + nonce + timestamp
     * @return 加密后的字符串
     */
    private static String sign(String plainStr, String key) {
        HMac hMac = SecureUtil.hmac(HmacAlgorithm.HmacSHA256, key);
        return hMac.digestHex(plainStr);
    }

    public static String hmacsha256(String plainStr,
                                    String key) {
        SecretKeySpec secretKey = new
                SecretKeySpec(key.getBytes(Charset.forName("UTF-8")),
                "HmacSHA256");
        Mac mac = null;
        try {
            mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
        } catch (NoSuchAlgorithmException |
                 InvalidKeyException e) {
            e.printStackTrace();
        }
        byte digest[] = mac.doFinal(plainStr.getBytes(Charset.forName("UTF-8")));
        return new
                StringBuilder().append(byte2HexStr(digest)).toString();
    }

    public static String byte2HexStr(byte array[]) {
        return array != null ? new
                String(Hex.encodeHex(array)) : null;
    }

}

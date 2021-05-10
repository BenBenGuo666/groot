package groot.shiro.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/4/20
 */
public class HttpUtils {

    public static String post(String addr) throws IOException {
        String responseString = null;
        HttpPost httpPost = new HttpPost(addr);
        CloseableHttpResponse response = HttpClients.custom().build().execute(httpPost);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            responseString = EntityUtils.toString(entity, "utf-8");

        }
        return responseString;
    }

}


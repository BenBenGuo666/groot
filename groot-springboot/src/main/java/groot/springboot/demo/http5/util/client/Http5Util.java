package groot.springboot.demo.http5.util.client;

import cn.hutool.core.collection.CollectionUtil;
import groot.springboot.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.apache.hc.core5.util.Timeout;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 14:34
 * @description:
 */
@Slf4j
public class Http5Util {

    private static final long CONNECT_TIMEOUT = 5000L;

    private static final long CONNECTION_REQUEST_TIMEOUT = 5000L;

    private static final long RESPONSE_TIMEOUT = 5000L;

    private static CloseableHttpClient httpClient;

    private static CloseableHttpClient getHttpClient() {
        if (null == httpClient) {
            RequestConfig config = RequestConfig.custom()
                    .setConnectTimeout(Timeout.ofMilliseconds(CONNECT_TIMEOUT))
                    .setConnectionRequestTimeout(Timeout.ofMilliseconds(CONNECTION_REQUEST_TIMEOUT))
                    .setResponseTimeout(Timeout.ofMilliseconds(RESPONSE_TIMEOUT))
                    .build();
            httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        }
        return httpClient;
    }

    public static String get(Http5Get http5Get) {
        String url = http5Get.getUri() + http5Get.getPath();
        HttpGet httpRequest = new HttpGet(url);
        httpRequest.addHeader(http5Get.getHeader());
        if (CollectionUtil.isNotEmpty(http5Get.getFormMap())) {
            // 表单参数
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            // POST 请求参数
            http5Get.getFormMap().keySet().stream().forEach(key ->
                    nameValuePairs.add(new BasicNameValuePair(key, http5Get.getFormMap().get(key)))
            );
            httpRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            try {
                URI uri = new URIBuilder(new URI(url))
                        .addParameters(nameValuePairs)
                        .build();
                httpRequest.setUri(uri);
                url = uri.toString();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("HttpRequest:{}", httpRequest);
        log.info("HttpRequest url:{}", url);
        log.info("HttpRequest headers:{}", JsonUtils.toGson(httpRequest.getHeaders()));
        try {
            CloseableHttpResponse response = getHttpClient().execute(httpRequest);
            log.info("HttpResponse headers:{}", JsonUtils.toGson(response.getHeaders()));
            log.info("HttpResponse:{}", response);
            HttpEntity entity = response.getEntity();
            // 获取响应信息
            String result = EntityUtils.toString(entity);
            log.info("HttpResponse entity:{}", result);
            // 确保流被完全消费
            EntityUtils.consume(entity);
            return result;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static String post(Http5Post http5Post) {
        String uri = http5Post.getUri() + http5Post.getPath();
        HttpPost httpRequest = new HttpPost(uri);
        httpRequest.addHeader(http5Post.getHeader());
        httpRequest.setEntity(new StringEntity(http5Post.getBody(), ContentType.APPLICATION_JSON));
        log.info("HttpRequest:{}", httpRequest);
        log.info("HttpRequest uri:{}", uri);
        log.info("HttpRequest headers:{}", JsonUtils.toGson(httpRequest.getHeaders()));
        try {
            CloseableHttpResponse response = getHttpClient().execute(httpRequest);
            log.info("HttpResponse headers:{}", JsonUtils.toGson(response.getHeaders()));
            log.info("HttpResponse:{}", response);
            HttpEntity entity = response.getEntity();
            // 获取响应信息
            String result = EntityUtils.toString(entity);
            log.info("HttpResponse entity:{}", result);
            // 确保流被完全消费
            EntityUtils.consume(entity);
            return result;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String postForm(Http5Post http5Post) {
        String uri = http5Post.getUri() + http5Post.getPath();
        HttpPost httpRequest = new HttpPost(uri);
        httpRequest.addHeader(http5Post.getHeader());
        if (CollectionUtil.isNotEmpty(http5Post.getFormMap())) {
            // 表单参数
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            // POST 请求参数
            http5Post.getFormMap().keySet().stream().forEach(key ->
                    nameValuePairs.add(new BasicNameValuePair(key, http5Post.getFormMap().get(key)))
            );
            httpRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs, StandardCharsets.UTF_8));
        }
        log.info("HttpRequest:{}", httpRequest);
        log.info("HttpRequest uri:{}", uri);
        log.info("HttpRequest headers:{}", JsonUtils.toGson(httpRequest.getHeaders()));
        try {
            CloseableHttpResponse response = getHttpClient().execute(httpRequest);
            log.info("HttpResponse headers:{}", JsonUtils.toGson(response.getHeaders()));
            log.info("HttpResponse:{}", response);
            HttpEntity entity = response.getEntity();
            // 获取响应信息
            String result = EntityUtils.toString(entity);
            log.info("HttpResponse Entity:{}", result);
            // 确保流被完全消费
            EntityUtils.consume(entity);
            return result;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

}

package groot.springboot.demo.http5;

import groot.springboot.demo.http5.util.reactor.SimpleHttpRequestCallback;
import groot.springboot.demo.utils.JsonUtils;
import org.apache.hc.client5.http.async.methods.*;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author: GuoBen~
 * @date: 2023/6/16 17:46
 * @description:
 */
public class AsyncClientHttpExchange {

    public static void main(final String[] args) throws Exception {

        final IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
                .setIoThreadCount(50)
                .setSoTimeout(Timeout.ofSeconds(5))
                .setSelectInterval(TimeValue.ofMilliseconds(50))
                .build();
        PoolingAsyncClientConnectionManager build = PoolingAsyncClientConnectionManagerBuilder.create()
                .setPoolConcurrencyPolicy(PoolConcurrencyPolicy.LAX)
                .setMaxConnPerRoute(6).build();

        CloseableHttpAsyncClient client = HttpAsyncClients.custom()
                .setIOReactorConfig(ioReactorConfig)
                .setConnectionManager(build)
                .disableAutomaticRetries()
                .build();
//        final CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
 /*       final CloseableHttpAsyncClient client = HttpAsyncClients.custom()
                .setIOReactorConfig(ioReactorConfig)
                .build();*/
/*
        RequestConfig config = RequestConfig.copy(RequestConfig.DEFAULT)
                .setConnectTimeout(150, TimeUnit.MILLISECONDS)
                .setConnectionRequestTimeout(200, TimeUnit.MILLISECONDS)
                .setResponseTimeout(100, TimeUnit.MILLISECONDS).build();*/

        client.start();
        String localhost = "http://127.0.0.1:9999";
        String testHost = "http://aiot.keyuannet.com:7000";
        final String[] requestUris = new String[]{"/user/useradmin/list", "/user/useradmin/list", "/dvadmin/group/detail/1661303923894194178"};
        String Authorization = "Bearer 12da6a2c-46b8-4fed-b5e3-e7da59fb81dd";
        for (int i = 0; i < requestUris.length; i++) {
            String requestUri = requestUris[i];
            Header httpHeaders = new BasicHeader(HttpHeaders.AUTHORIZATION, Authorization);
            final SimpleHttpRequest request;
            if (i == 2) {
                request = SimpleRequestBuilder.get(testHost)
                        .setPath(requestUri)
                        .setHeader(httpHeaders)
                        .build();
            } else {
                Map<String, Object> userQueryMap = new HashMap<>();
                userQueryMap.put("pageNumber", 1);
                userQueryMap.put("pageSize", 5);
                userQueryMap.put("nickname", (i == 0) ? "demo1" : "demo2");
                request = SimpleRequestBuilder.post(testHost)
                        .setHeader(httpHeaders)
                        .setBody(JsonUtils.toGson(userQueryMap).getBytes(StandardCharsets.UTF_8), ContentType.APPLICATION_JSON)
                        .setPath(requestUri)
                        .build();
            }
            System.out.println("request::" + request);
            System.out.println("request header::" + JsonUtils.toGson(request.getHeaders()));
            System.out.println("request contentType::" + request.getContentType());
            System.out.println("request body::" + request.getBodyText());
            System.out.println();
            final Future<SimpleHttpResponse> future = client.execute(
                    SimpleRequestProducer.create(request),
                    SimpleResponseConsumer.create(),
                    new SimpleHttpRequestCallback());
            SimpleHttpResponse simpleHttpResponse = future.get();
            System.out.println("request get::" + simpleHttpResponse);
        }

        System.out.println("Shutting down");
        client.close(CloseMode.GRACEFUL);
    }

}

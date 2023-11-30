package groot.springboot.demo.http5.util.reactor;

import cn.hutool.extra.spring.SpringUtil;
import groot.springboot.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.async.methods.*;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: GuoBen~
 * @date: 2023/6/30 09:48
 * @description:
 */
@Slf4j
public class AsyncReactorHttpUtil {

    private static CloseableHttpAsyncClient closeableHttpAsyncClient;

    public static CloseableHttpAsyncClient getAsyncClient() {
        if (null == closeableHttpAsyncClient) {
            /*synchronized (AsyncReactorHttpUtil.class) {
                if (null == closeableHttpAsyncClient) {
                    closeableHttpAsyncClient = SpringUtil.getBean(CloseableHttpAsyncClient.class);
                    if (null == closeableHttpAsyncClient) {
                        throw new RuntimeException("缺少 client 对象:closeableHttpAsyncClient");
                    }
                }
            }*/
            final IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
                    .setIoThreadCount(50)
                    .setSoTimeout(Timeout.ofSeconds(5))
                    .setSelectInterval(TimeValue.ofMilliseconds(50))
                    .build();
            PoolingAsyncClientConnectionManager build = PoolingAsyncClientConnectionManagerBuilder.create()
                    .setPoolConcurrencyPolicy(PoolConcurrencyPolicy.LAX)
                    .setMaxConnPerRoute(6).build();

            closeableHttpAsyncClient = HttpAsyncClients.custom()
                    .setIOReactorConfig(ioReactorConfig)
                    .setConnectionManager(build)
                    .disableAutomaticRetries()
                    .build();
            closeableHttpAsyncClient.start();
        }
        return closeableHttpAsyncClient;
    }


    /**
     * @param httpPost
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static String post(HttpPost httpPost) throws ExecutionException, InterruptedException {
        CloseableHttpAsyncClient client = getAsyncClient();
        final SimpleHttpRequest request = SimpleRequestBuilder.post(httpPost.getUri()).setBody(httpPost.getBody().getBytes(StandardCharsets.UTF_8), ContentType.APPLICATION_JSON).setPath(httpPost.getPath()).build();
        if (null != httpPost.getHeader()) {
            request.setHeader(httpPost.getHeader());
        }
        log.info("request--->{}", request);
        log.info("request header--->{}", JsonUtils.toGson(request.getHeaders()));
        log.info("request contentType--->{}", request.getContentType());
        log.info("request body--->{}", request.getBodyText());
        log.info("");
        final Future<SimpleHttpResponse> future = client.execute(
                SimpleRequestProducer.create(request),
                SimpleResponseConsumer.create(),
                new SimpleHttpRequestCallback());
        return new String(future.get().getBodyBytes(), StandardCharsets.UTF_8);
    }

    /**
     * @param httpGet
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static String get(HttpGet httpGet) throws ExecutionException, InterruptedException {
        CloseableHttpAsyncClient client = getAsyncClient();
        final SimpleHttpRequest request = SimpleRequestBuilder.get(httpGet.getUri())
                .setPath(httpGet.getPath()).build();
        if (null != httpGet.getHeader()) {
            request.setHeader(httpGet.getHeader());
        }
        log.info("request--->{}", request);
        log.info("request header--->{}", JsonUtils.toGson(request.getHeaders()));
        log.info("request contentType--->{}", request.getContentType());
        log.info("");
        final Future<SimpleHttpResponse> future = client.execute(
                SimpleRequestProducer.create(request),
                SimpleResponseConsumer.create(),
                new SimpleHttpRequestCallback());
        return new String(future.get().getBodyBytes(), StandardCharsets.UTF_8);
    }

}

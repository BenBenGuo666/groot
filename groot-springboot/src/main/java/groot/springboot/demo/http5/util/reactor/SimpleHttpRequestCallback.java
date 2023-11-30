package groot.springboot.demo.http5.util.reactor;

import groot.springboot.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.core5.concurrent.FutureCallback;

import java.nio.charset.StandardCharsets;

/**
 * @author: GuoBen~
 * @date: 2023/6/30 13:50
 * @description:
 */
@Slf4j
public class SimpleHttpRequestCallback implements FutureCallback<SimpleHttpResponse> {
    @Override
    public void completed(final SimpleHttpResponse response) {
        System.out.println("completed::");
        System.out.println("response::" + response);
        System.out.println("response header::" + JsonUtils.toGson(response.getHeaders()));
        System.out.println("response contentType::" + response.getContentType());
        System.out.println("response body::" + new String(response.getBodyBytes(), StandardCharsets.UTF_8));
        System.out.println();
        log.info("completed::");
        log.info("response::{}", response);
        log.info("response header::{}", JsonUtils.toGson(response.getHeaders()));
        log.info("response contentType::{}", response.getContentType());
        log.info("response body::{}", new String(response.getBodyBytes(), StandardCharsets.UTF_8));
        log.info("");
    }

    @Override
    public void failed(final Exception ex) {
        System.out.println("request failed::");
        System.out.println();
        log.error("request failed::");
        ex.printStackTrace();
        log.error("");
    }

    @Override
    public void cancelled() {
        System.out.println("request cancelled::");
        System.out.println();
        log.error("request cancelled::");
        log.error("");
    }
}

package groot.springboot.demo.http5.util.reactor;

import groot.springboot.demo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.HttpResponse;

/**
 * @author: GuoBen~
 * @date: 2023/7/10 14:20
 * @description:
 */
@Slf4j
public class HttpRequestCallback implements FutureCallback<HttpResponse> {
    @Override
    public void completed(final HttpResponse response) {
        log.info("completed::");
        log.info("response::{}", response);
        log.info("response header::{}", JsonUtils.toGson(response.getHeaders()));
        log.info("response body::{}", response.getReasonPhrase());
        log.info("");
    }

    @Override
    public void failed(final Exception ex) {
        log.error("request failed::");
        ex.printStackTrace();
        log.error("");
    }

    @Override
    public void cancelled() {
        log.error("request cancelled::");
        log.error("");
    }

}

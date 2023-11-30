package groot.springboot.demo.http5.util.reactor.config;

import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.core5.pool.PoolConcurrencyPolicy;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: GuoBen~
 * @date: 2023/6/30 14:07
 * @description:
 */
@Configuration
public class AsyncReactorHttpConfig {

    @Bean
    public CloseableHttpAsyncClient closeableHttpAsyncClient() {
        int ioThreadCount = 50;
        int soTimeoutOfSeconds = 5;
        int selectIntervalOfMilliseconds = 50;
        int maxConnPerRoute = 6;
        final IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
                .setIoThreadCount(ioThreadCount)
                .setSoTimeout(Timeout.ofSeconds(soTimeoutOfSeconds))
                .setSelectInterval(TimeValue.ofMilliseconds(selectIntervalOfMilliseconds))
                .build();
        PoolingAsyncClientConnectionManager build = PoolingAsyncClientConnectionManagerBuilder.create()
                .setPoolConcurrencyPolicy(PoolConcurrencyPolicy.LAX)
                .setMaxConnPerRoute(maxConnPerRoute)
                .build();

        CloseableHttpAsyncClient closeableHttpAsyncClient = HttpAsyncClients.custom()
                .setIOReactorConfig(ioReactorConfig)
                .setConnectionManager(build)
                .disableAutomaticRetries()
                .build();
        closeableHttpAsyncClient.start();
        return closeableHttpAsyncClient;
    }

}

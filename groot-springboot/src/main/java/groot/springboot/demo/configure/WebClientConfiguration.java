package groot.springboot.demo.configure;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.Duration;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/9/27
 */
@Configuration
public class WebClientConfiguration {

    @Value(value = "${webClient.provider.maxConnections}")
    private String maxConnections;

    private static final int MAX_CONNECTIONS_DEFAULT = 500;

    /*@Bean
    ReactorResourceFactory resourceFactory() {
        ReactorResourceFactory factory = new ReactorResourceFactory();
        factory.setUseGlobalResources(false);
        factory.setConnectionProvider(ConnectionProvider.builder("fixed pool")
                .maxConnections(StringUtils.isEmpty(maxConnections) ?
                        MAX_CONNECTIONS_DEFAULT : Integer.valueOf(maxConnections))
                .maxIdleTime(Duration.ofSeconds(20))
                .maxLifeTime(Duration.ofSeconds(60))
                .pendingAcquireTimeout(Duration.ofSeconds(60))
                .evictInBackground(Duration.ofSeconds(120))
                .build()
        );
        factory.setLoopResources(LoopResources.create("httpClient", 50, true));
        return factory;
    }

    @Bean
    WebClient webClient() {
        ClientHttpConnector connector =
                new ReactorClientHttpConnector(resourceFactory(), tcpClient -> HttpClient.create()
                        //连接超时
                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                        //TCP 节点延时
                        .option(ChannelOption.TCP_NODELAY, true)
                        .doOnConnected(connection -> {
                            connection.addHandlerLast(new ReadTimeoutHandler(10));
                            connection.addHandlerLast(new WriteTimeoutHandler(10));
                        }));
        return WebClient.builder().clientConnector(connector).build();
    }*/

}

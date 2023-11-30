package example;

import groot.springboot.demo.StartAppliction;
import groot.springboot.demo.websocket.client.handler.MyStompSessionHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;

/**
 * @author: GuoBen~
 * @date: 2023/4/4 17:16
 * @description:
 */
@Slf4j
@SpringBootTest(classes = StartAppliction.class)
public class WebSocketSTOMPClientDemo {

    @Autowired
    private TaskScheduler taskScheduler;

    public static void main(String[] args) throws InterruptedException {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());
        // for heartbeats
//        stompClient.setTaskScheduler(taskScheduler);
        String url = "ws://192.168.25.51:9091/v1/aiot";
        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        stompClient.connect(url, new StompSessionHandler() {

            @Override
            public Type getPayloadType(StompHeaders headers) {
                return null;
            }

            @Override
            public void handleFrame(StompHeaders headers, Object payload) {
                System.out.println("handleFrame");
            }

            @Override
            public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
                // ...
                log.info("连接已建立");
                System.out.println("连接已建立");
                session.send("/app/greeting", "payload");
            }

            @Override
            public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {

            }

            @Override
            public void handleTransportError(StompSession session, Throwable exception) {

            }
        });
        Thread.sleep(3000L);
    }

    @Test
    void test() throws ExecutionException, InterruptedException {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new StringMessageConverter());
        // for heartbeats
//        stompClient.setTaskScheduler(taskScheduler);
        String url = "ws://192.168.25.51:9091/v1/aiot";
        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        stompClient.connect(url, sessionHandler).completable();
    }

}

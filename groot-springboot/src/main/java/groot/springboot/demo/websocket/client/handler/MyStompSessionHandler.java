package groot.springboot.demo.websocket.client.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

/**
 * @author: GuoBen~
 * @date: 2023/4/4 17:32
 * @description:
 */
@Slf4j
public class MyStompSessionHandler extends StompSessionHandlerAdapter {

    @Override
    public void handleFrame(StompHeaders headers, @Nullable Object payload) {
        System.out.println("handleFrame");
        System.out.println("StompHeaders:" + headers);
        System.out.println("payload:" + payload);
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        // ...
        log.info("连接已建立");
        System.out.println("连接已建立");
//        session.subscribe("/execute_topic/script/execute", new MyStompFrameHandler());
//        session.subscribe("/execute_topic/script/execute2", new MyStompFrameHandler());
//        session.subscribe("/user/123456/execute_topic/script/execute", new MyStompFrameHandler());
//        session.subscribe("/user/execute_topic/script/execute", new MyStompFrameHandler());


    }

    @Override
    public void handleException(StompSession session, @Nullable StompCommand command,
                                StompHeaders headers, byte[] payload, Throwable exception) {
        log.error("连接异常");
        System.out.println("连接异常");
        System.out.println("session:" + session);
        System.out.println("command:" + command);
        System.out.println("headers:" + headers);
        System.out.println("payload:" + new String(payload));
        exception.printStackTrace();
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        log.error("连接失败");
        System.out.println("连接失败");
        System.out.println("session:" + session);
        exception.printStackTrace();
    }


}

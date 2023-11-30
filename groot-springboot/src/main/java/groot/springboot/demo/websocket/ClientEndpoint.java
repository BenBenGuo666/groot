package groot.springboot.demo.websocket;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;

/**
 * @author: GuoBen~
 * @date: 2023/4/4 13:31
 * @description:
 */
@javax.websocket.ClientEndpoint
@Slf4j
public class ClientEndpoint {

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        log.info("连接成功！sessionID：{}，config：{}", session.getId(), config);
    }

    public ClientEndpoint() {
        super();
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        log.warn("关闭连接！sessionId：{}，关闭原因：{}", session.getId(), closeReason);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        log.error("出错了！sessionId：{}", session.getId(), throwable);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("收到消息！sessionId: {}，message：{}", session.getId(), message);
        doOnMsg(session, message);
    }

    protected void doOnMsg(Session session, String message) {

    }

    @Slf4j
    @javax.websocket.ClientEndpoint
    public static class Client2 extends ClientEndpoint {
        @Override
        protected void doOnMsg(Session session, String message) {
            log.info("client2 doOnMsg:{},{}", session.getId(), message);
        }
    }


}

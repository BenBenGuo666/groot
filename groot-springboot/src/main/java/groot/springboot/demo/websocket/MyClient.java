package groot.springboot.demo.websocket;

import javax.websocket.ClientEndpoint;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

/**
 * @author: GuoBen~
 * @date: 2023/3/31 13:57
 * @description:
 */
@ClientEndpoint
public class MyClient extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler(String.class, (message) -> {
            System.out.println("Received: " + message);
        });
    }
}

package groot.springboot.demo.websocket;

import lombok.SneakyThrows;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

/**
 * @author: e-Benben.Guo
 * @date: 2023/3/31 11:43
 * @description:
 */
public class WebSocketClientDemo {

    static String TENANT_ID = "TENANT-ID";

    @SneakyThrows
    public static void main(String[] args) {

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://192.168.25.51:6001/adminws/ws/script/execute/123456";

        try {
            URI socketUri = URI.create(uri);
            Session session = container.connectToServer(ClientEndpoint.class, socketUri);

            session.getBasicRemote().sendText( "Hello World!");
        } catch (DeploymentException | IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(3000L);
    }

}

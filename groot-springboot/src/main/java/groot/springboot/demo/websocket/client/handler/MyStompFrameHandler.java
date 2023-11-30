package groot.springboot.demo.websocket.client.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import groot.springboot.demo.utils.JacksonUtil;
import groot.springboot.demo.utils.JsonUtils;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.util.MimeType;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: GuoBen~
 * @date: 2023/4/18 15:55
 * @description:
 */
public class MyStompFrameHandler implements StompFrameHandler {

    @Override
    public Type getPayloadType(StompHeaders headers) {
        System.out.println("MyStompFrameHandler.getPayloadType:" + headers);

        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("MyStompFrameHandler.handleFrame");
        System.out.println("MyStompFrameHandler.StompHeaders:" + headers);
        System.out.println("MyStompFrameHandler.payload:" + payload);
        try {
            Map map = JacksonUtil.jsonToPojo(String.valueOf(payload), Map.class);
            System.out.println(map);
        } catch (Exception e) {
            System.out.println("非 json 类型:" + payload);
        }
    }

}

package groot.springboot.demo.websocket.client.converter;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;

/**
 * @author: GuoBen~
 * @date: 2023/8/23 15:49
 * @description:
 */
public class DemoMessageConverter implements MessageConverter {
    @Override
    public Object fromMessage(Message<?> message, Class<?> targetClass) {

        return null;
    }

    @Override
    public Message<?> toMessage(Object payload, MessageHeaders headers) {

        return null;
    }
}

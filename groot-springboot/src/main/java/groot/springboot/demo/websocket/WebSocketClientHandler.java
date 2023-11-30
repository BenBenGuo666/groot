package groot.springboot.demo.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;

/**
 * @author: GuoBen~
 * @date: 2023/8/17 16:26
 * @description:
 */
public class WebSocketClientHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private final WebSocketClientHandshaker handshaker;

    public WebSocketClientHandler(WebSocketClientHandshaker handshaker) {
        this.handshaker = handshaker;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        // 处理接收到的 WebSocket 文本消息
        String message = msg.text();
        System.out.println("Received message: " + message);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 当连接激活时，发起 WebSocket 握手
        handshaker.handshake(ctx.channel());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 处理 WebSocket 握手成功事件
        if (evt == WebSocketClientProtocolHandler.ClientHandshakeStateEvent.HANDSHAKE_COMPLETE) {
            System.out.println("WebSocket handshake completed.");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 处理异常
        cause.printStackTrace();
        ctx.close();
    }

}

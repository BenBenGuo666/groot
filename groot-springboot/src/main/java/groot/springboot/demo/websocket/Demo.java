package groot.springboot.demo.websocket;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketFrameAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;

import java.net.URI;

/**
 * @author: GuoBen~
 * @date: 2023/8/17 16:23
 * @description:
 */
public class Demo {

    public static void main(String[] args) {
        // WebSocket 服务器的地址
        String serverUrl = "ws://192.168.25.51:6001/adminws/ws/script/execute/" + 123456;

        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            HttpHeaders httpHeaders = new DefaultHttpHeaders();
                            WebSocketClientHandshaker handshaker = WebSocketClientHandshakerFactory.newHandshaker(
                                    URI.create(serverUrl), WebSocketVersion.V13, null, false, httpHeaders, 65536);
                            ch.pipeline().addLast(
                                    new WebSocketClientHandler(handshaker),
                                    new WebSocketFrameAggregator(65536));
                        }
                    });
            Channel channel = bootstrap.connect("192.168.25.51", 6001).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            group.shutdownGracefully();
        }
    }
}
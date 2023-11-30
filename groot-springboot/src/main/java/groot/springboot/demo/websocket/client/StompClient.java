package groot.springboot.demo.websocket.client;

import groot.springboot.demo.utils.ThreadPoolUtil;
import groot.springboot.demo.websocket.client.handler.MyStompFrameHandler;
import groot.springboot.demo.websocket.client.handler.MyStompSessionHandler;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author: GuoBen~
 * @date: 2023/4/18 10:22
 * @description:
 */
public class StompClient {

    static StompSession stompSession;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String url = "ws://127.0.0.1:6001/adminws/ws/connect";
        CountDownLatch latch = new CountDownLatch(1);
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        // for heartbeats
        stompClient.setTaskScheduler(new DefaultManagedTaskScheduler());
        WebSocketHttpHeaders headers = new WebSocketHttpHeaders();
        // 设置URL协议升级
//        headers.set("Sec-WebSocket-Protocol", "v10.stomp");
        headers.set("deviceNo", "1234567");
        headers.set("deviceName", "demo2");
        headers.set("Authorization", "Bearer a0f98198-365d-4f48-a5ee-c3d65b54791d");
        ThreadPoolUtil.execute(
                () -> {
                    try {
                        stompSession = stompClient.connect(url, headers, new MyStompSessionHandler()).get();
                        stompSession.subscribe("/user/execute_topic/script/demo2", new MyStompFrameHandler());
                        stompSession.subscribe("/user/execute_topic/script/demo", new MyStompFrameHandler());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                    StompHeaders stompHeaders = new StompHeaders();
                    stompHeaders.set("destination", "/app/script/demo");
//                    stompHeaders.set("Authorization", "Bearer f8f9a07d-a9d2-4229-8a77-9e586ec25aba");
                    stompSession.send(stompHeaders, "helloWorld!");
                }
        );

        Thread.sleep(6000);
        latch.await();
        stompSession.disconnect();
        System.out.println("end");
//        stompClient.start();
        //实现stomp 客户端
     /*   Flux.fromArray(new Integer[]{1, 2, 3}).subscribe(e -> {
            System.out.println(e);
        });
        Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if(list.size() == 10){
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);*/

        /*Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
        Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
        Mono.create(monoSink -> monoSink.success("Hello")).subscribe(System.out::println);
        *//*Flux.just(5, 10).concatMap(integer ->
                Flux.interval(Duration.of(integer * 100, ChronoUnit.MILLIS)
                        ,Duration.of(integer * 100, ChronoUnit.MILLIS))
                        .take(integer))
                .toStream().forEach(System.out::println);*/
        /*Flux.just(5, 10).filterWhen(integer ->
            Mono.just(integer == 10)
        ).next().subscribe(System.out::println);*/

    }

}

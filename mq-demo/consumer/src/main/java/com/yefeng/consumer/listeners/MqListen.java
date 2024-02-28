package com.yefeng.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class MqListen {
    // 利用RabbitListener来声明要监听的队列信息
    // 将来一旦监听的队列中有了消息，就会推送给当前服务，调用当前方法，处理消息。
    // 可以看到方法体中接收的就是消息体的内容
//    @RabbitListener(queues = "yefeng")
//    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
//        System.out.println("spring 消费者接收到消息：【" + msg + "】");
//    }
//
//    @RabbitListener(queues = "yefeng.queue1")
//    public void listenYefengQueueMessage1(String msg) throws InterruptedException {
//        System.out.println("yefeng.queue1：【" + msg + "】");
//    }
//
//    @RabbitListener(queues = "yefeng.queue2")
//    public void listenYefengQueueMessage2(String msg) throws InterruptedException {
//        System.out.println("yefeng.queue2：【" + msg + "】");
//    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "yesterday", durable = "true"),
            exchange = @Exchange(name = "yefeng.fanout", type = ExchangeTypes.FANOUT)
    ))
    public void listeningMessageByFanout(String msg) {
        System.out.println(msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue"),
            exchange = @Exchange(name = "yefeng.topic", type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void listeningMessageByPrintout(Map msg) {
        System.out.println("spring listener1：【"+ msg.toString() + "】");
    }


    @RabbitListener(queuesToDeclare = @Queue(
            name = "lazy.queue",
            durable = "true",
            arguments = @Argument(name = "x-queue-mode", value = "lazy")
    ))
    public void listenLazyQueue(String msg){
        log.info("接收到 lazy.queue的消息：{}", msg);
    }
}

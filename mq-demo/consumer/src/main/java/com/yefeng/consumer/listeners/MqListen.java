package com.yefeng.consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class MqListen {
    // 利用RabbitListener来声明要监听的队列信息
    // 将来一旦监听的队列中有了消息，就会推送给当前服务，调用当前方法，处理消息。
    // 可以看到方法体中接收的就是消息体的内容
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
        log.info("接收到 simple.queue的消息：{}", msg);
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1接收到消息：【" + msg + "】" + LocalTime.now());
        log.info("消费者1接收到消息 = {}, 时间 = {}", msg,  LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "work.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException {
        log.info("消费者2接收到消息 = {}, 时间 = {}", msg,  LocalTime.now());
        Thread.sleep(200);
    }
//    @RabbitListener(queues = "yefeng.queue2")
//    public void listenYefengQueueMessage2(String msg) throws InterruptedException {
//        System.out.println("yefeng.queue2：【" + msg + "】");
//    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "yesterday", durable = "true"),
//            exchange = @Exchange(name = "yefeng.fanout", type = ExchangeTypes.FANOUT)
//    ))
//    public void listeningMessageByFanout(String msg) {
//        System.out.println(msg);
//    }
//
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "topic.queue"),
//            exchange = @Exchange(name = "yefeng.topic", type = ExchangeTypes.TOPIC),
//            key = "china.#"
//    ))
//    public void listeningMessageByPrintout(Map msg) {
//        System.out.println("spring listener1：【"+ msg.toString() + "】");
//    }
//
//
//    @RabbitListener(queuesToDeclare = @Queue(
//            name = "lazy.queue",
//            durable = "true",
//            arguments = @Argument(name = "x-queue-mode", value = "lazy")
//    ))
//    public void listenLazyQueue(String msg){
//        log.info("接收到 lazy.queue的消息：{}", msg);
//    }
//
//    /**
//     * 字符串拆分成数组，例如”ab&&2”通过”&&”做分隔符，分割得到字符串数组[“ab”,”2”]
//     * 实现字符串组合，例如[“ab”,”2”]通过”&&”分隔符，组合成字符串”ab&&2”
//     */
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = "mom", durable = "true"),
//            exchange = @Exchange(name = "yefeng.headers", type = ExchangeTypes.HEADERS)
//    ))
//    public void listeningMessageByHeaders(String msg) {
//        String delimiter = "&&";
//        List<String> result = new ArrayList<>();
//        int startIndex = 0;
//        int endIndex = msg.indexOf(delimiter);
//
//        while (endIndex != -1) {
//            result.add(msg.substring(startIndex, endIndex));
//            startIndex = endIndex + delimiter.length();
//            endIndex = msg.indexOf(delimiter, startIndex);
//        }
//
//        result.add(msg.substring(startIndex)); // 添加最后一个部分
//
//        System.out.println(result.toArray(new String[0]));
//    }

}

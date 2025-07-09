package main.test.queue;

import main.java.datastructure.queue.ArrayQueue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>(5);
        queue.addQueue("ak");
        queue.addQueue("欧阳");
        queue.addQueue("小杨哥");
        queue.addQueue("yf");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("队头为：" + queue.getQueue());
        queue.popQueue();
        System.out.println("队头为：" + queue.getQueue());
        int month = Integer.parseInt("01");
        System.out.println(month);
    }
}

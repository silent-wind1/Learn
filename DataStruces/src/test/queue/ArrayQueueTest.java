package test.queue;

import DataStrues.queue.ArrayQueue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<>(5);
        queue.addQueue("田思凯");
        queue.addQueue("欧阳志飞");
        queue.addQueue("小杨哥");
        queue.addQueue("唐曦");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("队头为：" + queue.getQueue());
        queue.popQueue();
        System.out.println("队头为：" + queue.getQueue());

    }
}

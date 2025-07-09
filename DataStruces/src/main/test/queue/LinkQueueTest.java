package main.test.queue;

import main.java.datastructure.queue.LinkQueue;

public class LinkQueueTest {
    public static void main(String[] args) {
        LinkQueue<String> queue = new LinkQueue<>();
        queue.addQueue("湖南财政");
        queue.addQueue("湖南理工");
        queue.addQueue("湖南工学院");
        queue.addQueue("湖南人文学院");
        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println("出队元素：" + queue.popQueue()+ "\n链表大小：" + queue.length());
    }
}

package DataStrues.queue;

import java.util.Iterator;

public class LinkQueue<T> implements Iterable<T>{
    private Node front; // 首节点
    private Node rear; // 最后一个节点
    private int N;


    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkQueue() {
        this.front = new Node(null, null);
        this.rear = null;
        this.N = 0;
    }

    public Boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public void addQueue(T t) {
        if (rear == null) {
            // 如果尾结点为空，直接把新结点赋给尾结点，首节点指向尾结点
            Node n = front;
            rear = new Node(t, null);
            n.next = rear;
        } else {
            // 不为空则代表有元素，直接把next指向新结点
            rear.next = new Node(t, null);
            rear = rear.next;
        }
        N++;
    }

    public T popQueue() {
        if (isEmpty()) {
            return null;
        }
        Node n = front.next;
        front.next = n.next;
        N--;
        if (isEmpty()) {
            rear = null;
        }
        return n.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    private class  QIterator implements Iterator {
        private Node n;

        public QIterator() {
            this.n = front;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}

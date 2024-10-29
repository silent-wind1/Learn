package main.java.datastructure.link;

import java.util.Iterator;

public class TowWayLinkList<T> implements ListMethods<T>, Iterable<T> {
    private Node head;
    private Node last;
    private int N;

    private class Node {
        public T item;
        public Node pre;
        public Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    /**
     * 实例化
     */
    public TowWayLinkList() {
        this.head = new Node(null, null, null);
        this.last = null;
        N = 0;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
        this.N = 0;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 链表的长度
     *
     * @return
     */
    @Override
    public int length() {
        return N;
    }

    /**
     * 获取到第一个链表的元素
     *
     * @return
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    /**
     * 获取链表最后一个元素
     *
     * @return
     */
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    @Override
    public T get(int i) {
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    @Override
    public void insert(T t) {
        // 如果链表为空
        if (isEmpty()) {
            // 创建新的结点
            Node n = new Node(t, head, null);
            // 让新结点为尾结点
            last = n;
            // 在把头部结点指向尾结点
            head.next = last;
        } else {
            Node n = new Node(t, last, null);
            last.next = n;
            last = n;
        }
        N++;
    }

    @Override
    public void insert(int i, T t) {
        // 找到i位置的前一个结点
        Node n = head;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        // 找到i位置的结点
        Node curr = n.next;
        // 创建一个新结点，把这个pre结点指向n， 把next指向curr
        Node node = new Node(t, n, curr);
        n.next = node;
        curr.pre = node;
        N++;
    }

    @Override
    public T remove(int i) {
        Node n = head;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        Node curr = n.next;
        n.next = curr.next;
        curr.pre = n;
        N--;
        return curr.item;
    }

    @Override
    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator {
        private Node n;

        public TIterator() {
            this.n = head;
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

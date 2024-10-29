package main.java.datastructure.stack;

import java.util.Iterator;

public class StackLink<T> implements Iterable<T>{
    private Node head;
    private int N;

    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    /**
     * 初始化
     */
    public StackLink() {
        this.head = new Node(null, null);
        this.N = 0;

    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取长度
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 把t元素压入栈
     * @param t
     */
    public void push(T t) {
        // 找到首节点指向的第一个结点
        Node node = head.next;
        // 创建新结点
        Node newNode = new Node(t, null);
        // 让首结点指向新结点
        head.next = newNode;
        // 让新结点指向原来的第一个结点
        newNode.next = node;
        // 元素个数加1
        N++;
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        Node node = head.next;
        if(node == null) {
            return null;
        }
        head.next = node.next;
        N--;
        return node.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private  Node n;

        public SIterator() {
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

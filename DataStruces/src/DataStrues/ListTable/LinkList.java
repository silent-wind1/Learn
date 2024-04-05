package DataStrues.ListTable;

import java.util.Iterator;

public class LinkList<T> implements ListMethods<T>, Iterable<T> {
    private Node head;
    private int N;

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    @Override
    public void clear() {
        head.next = null;
        this.N = 0;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int length() {
        return N;
    }

    @Override
    public T get(int i) {
        if(head.next == null) {
            return null;
        }
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    @Override
    public void insert(T t) {
        Node n = head;  // 把头节点复制给一个新元素
        while (n.next != null) {
            n = n.next;
        }
        n.next = new Node(t, null);
        N++;
    }

    @Override
    public void insert(int i, T t) {
        Node n = head;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        n.next = new Node(t, n.next);
        N++;
    }

    @Override
    public T remove(int i) {
        Node n = head;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        Node name = n.next;
        n.next = name.next;
        N--;
        return name.item;
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

    /**
     * 用来反转整个链表
     */
    public void reverse() {
        // 判断当前链表是否为空链表
        if (isEmpty()) {
            return;
        }
        reverse(head.next);
    }

    /**
     * 反转指定的结点curr， 并把反转后的结点返回
     *
     * @param curr
     * @return
     */
    public Node reverse(Node curr) {
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }
        // 递归的反转当前结点curr的下一个结点，返回值就是链表反转后，当前结点的上一个结点
        Node pre = reverse(curr.next);
        // 让返回结点的下一个结点变味当前结点curr
        pre.next = curr;
        // 把当前结点的下一个结点变为null
        curr.next = null;
        return curr;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator {
        private Node n;

        public LIterator() {
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

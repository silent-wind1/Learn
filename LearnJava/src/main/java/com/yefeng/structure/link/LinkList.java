package com.yefeng.structure.link;

import java.util.Iterator;

/**
 * @Author: 叶枫
 * @Date: 2025/04/22/18:12
 * @Description:
 */
public class LinkList<T extends Comparable<T>> implements Iterable<T> {
    // 头节点
    private final Node head;
    // 链表数量
    private int N;

    /**
     * 内部类
     */
    private class Node {
        T data;
        Node next;
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    /**
     * 清空链表
     */
    public void clear() {
        // 只需要把头结点next指向null
        head.next = null;
        this.N = 0;
    }

    /**
     * 判断链表是否为空
     * @return 为空返回ture，负责返回false
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 链表长度
     * @return 返回链表长度
     */
    public int size() {
        return N;
    }

    /**
     * 添加元素
     * @param data 元素
     */
    public void add(T data) {
        // 把头节点复制给一个新元素
        Node node = head;
        // 循环遍历找到尾结点
        while (node.next != null) {
            node = node.next;
        }
        //
        node.next = new Node(data, null);
        this.N++;
    }

    /**
     * 添加指定元素
     * @param index 下标
     * @param data 元素
     */
    public void add(int index, T data) {
        Node node = head;
        while(index > 0) {
            node = node.next;
            index--;
        }
        node.next = new Node(data, node.next);
        this.N++;
    }


    /**
     * 合并两个有序链表，前提是两个链表里面的值都是有序的
     * @param other 第二个链表
     * @return 合并完的有序链表
     */
    public LinkList<T> merge(LinkList<T> other) {
        if(other == null || other.isEmpty()) {
            return this;
        }
        if(this.isEmpty()) {
            return other;
        }
        LinkList<T> result = new LinkList<>();
        Node dummy = new Node(null, null); // dummy 节点用于简化操作
        Node tail = dummy;
        Node p1 = this.head.next;
        Node p2 = other.head.next;
        // 如果p1和p2链表都不为空
        while (p1 != null && p2 != null) {
            // 比较p1.data和p2.data谁打谁小
            if(p1.data.compareTo(p2.data) <= 0) {
                // 如果成立p3指向p1.data
                tail.next = new Node(p1.data, null);
                p1 = p1.next;
            } else {
                tail.next = new Node(p2.data, null);
                p2 = p2.next;
            }
            tail = tail.next;
        }
        // 可能存在p1没有循环完
        while(p1 != null) {
            tail.next = new Node(p1.data, null);
            p1 = p1.next;
            tail = tail.next;
        }

        // 可能存在p2没有循环完
        while(p2 != null) {
            tail.next = new Node(p2.data, null);
            p2 = p2.next;
            tail = tail.next;
        }

        result.head.next = dummy.next;
        result.N = other.N + this.N;
        return result;
    }

    /**
     * 对链表进行归并排序
     */
    public void mergeSortCore() {
        head.next = mergeSortCore(head.next);
    }

    /**
     * 递归地对链表进行归并排序
     * @param head 当前子链表的头节点
     * @return 排序后的链表头节点
     */
    private Node mergeSortCore(Node head) {
        // 递归终止条件：空链表或单个节点，天然有序
        if(head == null || head.next == null) {
            return head;
        }
        // 快慢指针，找链表中间点
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 断开链表，分成左右两部分
        Node mid = slow.next;
        slow.next = null;
        // 对左右部分分别归并排序
        Node left = mergeSortCore(head);
        Node right = mergeSortCore(mid);
        // 合并两个已排序链表
        return mergeTwoSortedLists(left, right);
    }

    /**
     *
     * 合并两个有序链表
     * @param l1 第一个有序链表头节点
     * @param l2 第二个有序链表头节点
     * @return 合并后的有序链表头节点
     */
    private Node mergeTwoSortedLists(Node l1, Node l2) {
        // 哨兵节点，便于处理头指针
        Node dummy = new Node(null, null);
        Node curr = dummy;
        // 遍历两个链表，按顺序依次连接
        while(l1 != null && l2 != null) {
            if(l1.data.compareTo(l2.data) <= 0) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        // 剩余未合并部分直接拼接
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    /**
     * 反转链表
     */
    public void reverse() {
        // 判断当前链表是否为空链表
        if (isEmpty()) {
            return;
        }
        Node current = head.next, prev = null;
        while(current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        // 更新头结点指向新的头部
        this.head.next = prev;
    }


    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head.next;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}

package algorithm.reverselink;

/**
 * @author: yefeng
 * @description: 反转链表
 * @date: 2023/12/17 0:31
 * @version: 1.0
 */
public class ReverseLink {
    private ListNode head;

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 添加元素
     *
     * @param t 元素
     */
    public void insert(int t) {
        ListNode n = head;  // 把头节点复制给一个新元素
        while (n.next != null) {
            n = n.next;
        }
        n.next = new ListNode(t);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList(ListNode head) {
        // write code here
        ListNode top = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = top;
            top = head;
            head = next;
        }
        return top;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        ListNode pre = new ListNode(0);
        pre.next = head;  // 指向头节点
        ListNode preStart = pre;
        ListNode start = head;
        for (int i = 1; i < m; i++) {
            preStart = start;
            start = start.next;
        }
        for (int j = 0; j < n - m; j++) {
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
        }
        return pre.next;
    }
}

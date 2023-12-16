package algorithm.reverselink;

/**
 * @author: yefeng
 * @description: 反转链表
 * @date: 2023/12/17 0:31
 * @version: 1.0
 */
public class ReverseLink {
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

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

}

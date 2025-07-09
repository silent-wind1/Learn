package main.test.ListTable;

public class FastSlowTest {
    public static void main(String[] args) {
        Node one = new Node("one", null);
        Node two = new Node("two", one);
        Node three = new Node("three", two);
        Node four = new Node("four", three);
        Node five = new Node("five", four);
        Node six = new Node("six", five);

        Node mid = getMid(six);
        System.out.println(mid.item);
    }

    private static Node getMid(Node five) {
        Node Fast = five;
        Node Slow = five;
        while (Fast.next != null && Fast.next.next != null) {
            Fast = Fast.next.next;
            Slow = Slow.next;
        }
        return Slow;
    }

    private static class Node<T> {
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}

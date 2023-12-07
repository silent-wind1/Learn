package DataStrues.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] value = {3, 25, 8, 10, 9, 5};
        Node root = createHuffmanTree(value);
        preOrder(root);
    }

    public static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }
    }

    public static Node createHuffmanTree(int[] value){
        List<Node> nodes = new ArrayList<Node>();
        for (int node : value) {
            nodes.add(new Node(node));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
//            System.out.print(nodes + "\t ");
            // 去除权值最小的结点
            Node leftNode = nodes.get(0);
            // 取出权值第二小的结点
            Node rightNode = nodes.get(1);
            // 构建一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            // 从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);

            // 将parent加入nodes
            nodes.add(parent);
        }

        // 返回
        return nodes.get(0);
    }

}

class Node implements Comparable<Node> {
    public int value; // 结点权值
    public Node left; // 指向左子节点
    public Node right; // 指向有子节点

    public Node(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.print(this + "\t");
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        // 从小到大
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}

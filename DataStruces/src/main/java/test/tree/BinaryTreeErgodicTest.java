package main.java.test.tree;

import main.java.datastructure.queue.LinkQueue;
import main.java.datastructure.tree.BinaryTree;

public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String, String> tree = new BinaryTree<>();
//        tree.put("E", "5");
//        tree.put("B", "2");
//        tree.put("G", "7");
//        tree.put("A", "1");
//        tree.put("D", "4");
//        tree.put("F", "6");
//        tree.put("H", "8");
//        tree.put("C", "3");
        tree.put("4", "Y");
        tree.put("3", "Y");
        tree.put("5", "Y");
        tree.put("1", "Y");
        tree.put("7", "Y");
        tree.put("2", "Y");
        tree.put("6", "Y");

        System.out.println("-----------前序遍历-----------");
        LinkQueue<String> key = tree.preErgodic();
        for (String s : key) {
            System.out.print(s + "\t");
        }

        System.out.println("\n-----------中序遍历-----------");
        LinkQueue<String> keys = tree.midErgodic();
        for (String s : keys) {
            System.out.print(s + "\t");
        }



        System.out.println("\n-----------后序遍历-----------");
        LinkQueue<String> key1 = tree.rightErgodic();
        for (String s : key1) {
            System.out.print(s + "\t");
        }
        // 层序遍历
        System.out.println("\n-----------层序遍历-----------");
        LinkQueue<String> s = tree.layerErgodic();
        for (String s1 : s) {
            System.out.print(s1 + "\t");
        }
    }
}

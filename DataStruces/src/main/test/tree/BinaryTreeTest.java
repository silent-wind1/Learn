package main.test.tree;

import main.java.datastructure.tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        // 创建二叉查找树对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1, "叶枫");
        tree.put(2, "欧阳");
        tree.put(3, "思凯");
        System.out.println(tree.length());

        // 获取
        System.out.println("key == 2:" + tree.get(2));

        // delete
        tree.delete(3);
        System.out.println("delete == 3\t" + tree.length());
        System.out.println("key == 3:" + tree.get(3));
    }
}

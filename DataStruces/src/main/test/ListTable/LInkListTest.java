package main.test.ListTable;

import main.java.datastructure.link.LinkList;

public class LInkListTest {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        list.insert("叶枫");
        list.insert("欧阳志飞");
        list.insert("杨圣波");
        list.insert(0, "思凯");
        list.insert("慧娟");
        System.out.println("链表是否为空链表：" + list.isEmpty());
        System.out.println("链表长度为：" + list.length());
        System.out.println("被删除的人是:" + list.remove(2));
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-------------反转后-------------");
        list.reverse();
        for (String s : list) {
            System.out.println(s);
        }
    }
}

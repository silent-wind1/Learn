package com.yefeng.structure.link;

/**
 * @Author: 叶枫
 * @Date: 2025/04/22/19:10
 * @Description:
 */
public class LinkTest {
    public static void main(String[] args) {
        LinkList<Integer> linkList1 = new LinkList<>();
        linkList1.add(1);
        linkList1.add(3);
        LinkList<Integer> linkList2 = new LinkList<>();
        linkList2.add(2);
        linkList2.add(4);
        linkList2.add(5);
        LinkList<Integer> merge = linkList1.merge(linkList2);
        for (Integer data : merge) {
            System.out.print(data + "\t");
        }

        System.out.println("\n 反转之后的数组");
        merge.reverse();
        for (Integer item : merge) {
            System.out.print(item + "\t");
        }
    }
}

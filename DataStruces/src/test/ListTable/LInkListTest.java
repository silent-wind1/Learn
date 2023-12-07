package test.ListTable;

import DataStrues.ListTable.LinkList;

public class LInkListTest {
    public static void main(String[] args) {
        LinkList<String> list = new LinkList<>();
        list.insert("叶枫");
        list.insert("欧阳志飞");
        list.insert("杨圣波");
        list.insert(0, "思凯");
        System.out.println("被删除的人是:" + list.remove(1));
        for (String s : list) {
            System.out.println(s);
        }
//        System.out.println("-------------反转后-------------");
//        list.reverse();
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        String str = "*";
//        if(str.equals("*")) {
//            System.out.println("123");
//        }
    }
}

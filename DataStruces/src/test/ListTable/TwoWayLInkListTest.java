package test.ListTable;

import DataStrues.ListTable.TowWayLinkList;

public class TwoWayLInkListTest {
    public static void main(String[] args) {
        TowWayLinkList<String> list = new TowWayLinkList<>();
        list.insert("叶枫");
        list.insert("欧阳志飞");
        list.insert("杨圣波");
        list.insert(0, "思凯");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("----------------------------");
        System.out.println("被删除的人是:" + list.remove(2));
        System.out.println("---------------------------");
        System.out.println("getFirst：" + list.getFirst());
        System.out.println("---------------------------");
        System.out.println("getLast：" + list.getLast());
        int[] a = {1, 2, 3};
        int[] b = a;
        System.out.println(a);
        System.out.println(b);
        a[1] = 3;
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + "," + b[i]);
        }
    }
}

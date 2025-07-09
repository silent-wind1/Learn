package main.test.ListTable;

import main.java.datastructure.link.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> se = new SequenceList<>(10);
        se.insert("姚明");
        se.insert("yefeng");
        se.insert("Tangxi");
        se.insert("ouyang");
        se.insert(3, "上岸");

        for (String s : se) {
            System.out.println(s);
        }
        System.out.println("----------------------------");
        String getResult = se.get(3);
        System.out.println(getResult);

        String removeResult = se.remove(0);
        System.out.println(removeResult);
        se.clear();
        System.out.println(se.length());
    }
}

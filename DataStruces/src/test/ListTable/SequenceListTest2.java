package test.ListTable;

import DataStrues.ListTable.SequenceList;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试顺序表是否扩容成功
 */
public class SequenceListTest2 {
    public static void main(String[] args) {
        SequenceList<String> se = new SequenceList<>(3);
        se.insert("yefeng");
        se.insert("财政");
        se.insert("理工");
        se.insert("工学院 ");
        List list = new ArrayList();
    }
}

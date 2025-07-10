package main.test.hash;


import main.java.datastructure.hash.ArrayHashMap;
import main.java.datastructure.hash.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yefeng
 */
public class ArrayHashMapTest {
    public static void main(String[] args) {
        ArrayHashMap map = new ArrayHashMap();
        map.put(1, "张三");
        map.put(2, "李四");
        map.put(3, "王五");
        // 删除键为3的键值对
        map.remove(3);
        // 打印键值对
        map.print();
        System.out.println("-----分隔符-----");
        List<Integer> keySet = map.getKeySet();
        for (Integer key : keySet) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}

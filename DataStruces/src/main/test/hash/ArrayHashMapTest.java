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
        System.out.println(map.get(3));
        map.remove(3);
        System.out.println(map.get(3));
    }
}

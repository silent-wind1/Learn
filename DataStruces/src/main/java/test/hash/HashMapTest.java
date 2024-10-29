package main.java.test.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        // 推荐 使用 迭代器 EntrySet
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.print(entry.getKey() + "\t");
            System.out.println(entry.getValue());
        }
        System.out.println();
        // 迭代器 KeySet
        Iterator<Integer> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()) {
            Integer key = iterator1.next();
            System.out.print(key + "\t");
            System.out.println(map.get(key));
        }
        System.out.println();

        // ForEach EntrySet
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "\t");
            System.out.println(entry.getValue());
        }
        System.out.println();
        // ForEach KeySet遍历
        for (Integer key : map.keySet()) {
            System.out.print(key + "\t");
            System.out.println(map.get(key));
        }
        System.out.println();

        // Lambda遍历
        map.forEach((key, value) -> {
            System.out.print(key + "\t");
            System.out.println(value);
        });

        System.out.println();
        //Streams API 单线程遍历
        map.entrySet().stream().forEach((entry) -> {
            System.out.print(entry.getKey() + "\t");
            System.out.println(entry.getValue());
        });
    }
}

package com.yefeng.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 这段代码有什么性能问题，如何去优化？
 */
public class ListPerformance {
    public static void main(String[] args) {
        // 可以指定 ArrayList 初始容量
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add("item" + i);
        }
        // 可读性优化：使用增强 for 循环
        // 若需要输出全部元素，采用 StringBuilder 批量输出
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            // 处理 item
            System.out.println(item);
        }
    }
}
package com.yefeng.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wind
 * @description:
 * @date 2025/12/19 12:22
 */
public class HeapMaxDemo {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while(true) {
            list.add(new Byte[1024 * 1024 * 100]);
        }
    }
}

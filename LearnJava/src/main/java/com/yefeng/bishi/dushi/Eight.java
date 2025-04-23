package com.yefeng.bishi.dushi;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/18:18
 * @Description: 笃实科技笔试题第八题, 考察点: 树形结构
 */
public class Eight {
    @Data
    static class Address {
        private String id;
        private String pid;
        private String name;
        private String number;
        private List<Address> children = new ArrayList<>();

        public Address(String id, String pid, String name, String number) {
            this.id = id;
            this.pid = pid;
            this.name = name;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        Map<String, Address> addresses = new HashMap<>();
        addresses.put("0", new Address("0", null, null, null));
        addresses.put("1", new Address("1", "0", "广东", "44"));
        addresses.put("2", new Address("2", "0", "湖北", "42"));
        addresses.put("3", new Address("3", "1", "深圳市", "4403"));
        addresses.put("4", new Address("4", "1", "广州市", "4401"));
        addresses.put("5", new Address("5", "2", "黄冈市", "4211"));
        addresses.put("6", new Address("6", "2", "武汉市", "4201"));
        addresses.put("7", new Address("7", "3", "南山区", "440305"));
        addresses.put("8", new Address("8", "3", "福田区", "440304"));
        addresses.put("9", new Address("9", "4", "天河区", "440106"));
        addresses.put("10", new Address("10", "4", "越秀区", "440104"));
        for (Address address : addresses.values()) {
            // 根据pid查找父节点
            Address parentAddress = addresses.get(address.getPid());
            if (parentAddress != null) {
                // 将当前地址添加为父节点的子节点
                parentAddress.getChildren().add(address);
            }
        }
        // 从根节点开始递归打印树形结构
        printTree(addresses.get("0"), 0);
    }

    // 递归打印树形结构的方法
    private static void printTree(Address address, int level) {
        // 仅打印有名称的节点
        if(address.getName() != null) {
            // 根据层级生成缩进（每层一个制表符）
            for (int i = 1; i < level; i++) {
                System.out.print("\t");
            }
            // 输出地址名称
            System.out.println("-" + address.getName());
        }
        // 递归打印所有子节点，层级+1
        for (Address child : address.getChildren()) {
            printTree(child, level + 1);
        }
    }
}

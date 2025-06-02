package com.yefeng.bishi.zhuoxun;

import java.util.*;

/**
 * @Author: 叶枫
 * @Date: 2025/06/02/17:17
 * @Description: 卓讯第十一题， 实现多级树结构搜索
 */
public class Eleven {

    public static void main(String[] args) {
        // 构建测试数据
        List<Map<String, Object>> tree = buildTestTree();

        // 查找id="204"的节点
        Map<String, Object> result = searchNode(tree, "204");

        if (result != null) {
            System.out.println("找到节点: " + result.get("name")); // 输出: 找到节点: 福田区
        } else {
            System.out.println("未找到节点");
        }
    }

    // 递归深度优先搜索实现
    public static Map<String, Object> searchNode(List<Map<String, Object>> list, String id) {
        if (list == null || id == null) return null;

        for (Map<String, Object> node : list) {
            // 检查当前节点
            if (id.equals(node.get("id"))) {
                return node;
            }

            // 检查子节点
            if (node.containsKey("nodes")) {
                @SuppressWarnings("unchecked") List<Map<String, Object>> childNodes = (List<Map<String, Object>>) node.get("nodes");

                Map<String, Object> result = searchNode(childNodes, id);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    // 非递归深度优先搜索实现（使用栈）
    public static Map<String, Object> searchNodeDFS(List<Map<String, Object>> list, String id) {
        if (list == null || id == null) return null;

        Stack<List<Map<String, Object>>> stack = new Stack<>();
        stack.push(list);

        while (!stack.isEmpty()) {
            List<Map<String, Object>> currentList = stack.pop();

            for (int i = currentList.size() - 1; i >= 0; i--) {
                Map<String, Object> node = currentList.get(i);

                // 检查当前节点
                if (id.equals(node.get("id"))) {
                    return node;
                }

                // 添加子节点到栈中
                if (node.containsKey("nodes")) {
                    @SuppressWarnings("unchecked") List<Map<String, Object>> childNodes = (List<Map<String, Object>>) node.get("nodes");
                    if (childNodes != null && !childNodes.isEmpty()) {
                        stack.push(childNodes);
                    }
                }
            }
        }
        return null;
    }

    // 广度优先搜索实现
    public static Map<String, Object> searchNodeBFS(List<Map<String, Object>> list, String id) {
        if (list == null || id == null) return null;

        Queue<List<Map<String, Object>>> queue = new LinkedList<>();
        queue.add(list);

        while (!queue.isEmpty()) {
            List<Map<String, Object>> currentList = queue.poll();

            for (Map<String, Object> node : currentList) {
                // 检查当前节点
                if (id.equals(node.get("id"))) {
                    return node;
                }

                // 添加子节点到队列
                if (node.containsKey("nodes")) {
                    @SuppressWarnings("unchecked") List<Map<String, Object>> childNodes = (List<Map<String, Object>>) node.get("nodes");
                    if (childNodes != null && !childNodes.isEmpty()) {
                        queue.add(childNodes);
                    }
                }
            }
        }
        return null;
    }

    // 构建测试树
    private static List<Map<String, Object>> buildTestTree() {
        Map<String, Object> node003 = new HashMap<>();
        node003.put("id", "003");
        node003.put("name", "天河区");

        Map<String, Object> node004 = new HashMap<>();
        node004.put("id", "004");
        node004.put("name", "海珠区");

        Map<String, Object> node203 = new HashMap<>();
        node203.put("id", "203");
        node203.put("name", "南山区");

        Map<String, Object> node204 = new HashMap<>();
        node204.put("id", "204");
        node204.put("name", "福田区");

        List<Map<String, Object>> guangzhouNodes = List.of(node003, node004);
        Map<String, Object> guangzhou = new HashMap<>();
        guangzhou.put("id", "101");
        guangzhou.put("name", "广州市");
        guangzhou.put("nodes", guangzhouNodes);

        List<Map<String, Object>> shenzhenNodes = List.of(node203, node204);
        Map<String, Object> shenzhen = new HashMap<>();
        shenzhen.put("id", "202");
        shenzhen.put("name", "深圳市");
        shenzhen.put("nodes", shenzhenNodes);

        List<Map<String, Object>> guangdongNodes = List.of(guangzhou, shenzhen);
        Map<String, Object> guangdong = new HashMap<>();
        guangdong.put("id", "001");
        guangdong.put("name", "广东省");
        guangdong.put("nodes", guangdongNodes);

        return List.of(guangdong);
    }
}

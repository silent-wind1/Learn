package main.java.datastructure.hash;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yefeng
 */
public class ArrayHashMap {
    private List<Pair> buckets;

    /**
     * 创建一个100个桶的哈希表
     */
    public ArrayHashMap() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            buckets.add(null);
        }
    }

    /**
     * 计算key的哈希值
     * @param key 键
     * @return 哈希值
     */
    private int hash(int key) {
        return key % 100;
    }

    /**
     * 添加键值对
     * @param key 键
     * @param value 值
     */
    public void put(int key, String value) {
        Pair pair = new Pair(key, value);
        int hash = hash(key);
        buckets.set(hash, pair);
    }

    /**
     * 获取值
     * @param key 键
     * @return 值
     */
    public String get(int key) {
        int hash = hash(key);
        Pair pair = buckets.get(hash);
        if(pair == null) {
            return null;
        }
        return pair.getValue();
    }

    /**
     * 删除键值对
     * @param key 键
     */
    public void remove(int key) {
        int hash = hash(key);
        buckets.set(hash, null);
    }

    /**
     * 获取所有的键
     *
     * @return 所有的Key集合
     */
    public List<Integer> getKeySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                keySet.add(pair.getKey());
            }
        }
        return keySet;
    }

    /**
     * 获取所有的值
     *
     * @return 所有的值集合
     */
    public List<String> getValueSet() {
        List<String> valueSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null) {
                valueSet.add(pair.getValue());
            }
        }
        return valueSet;
    }

    /**
     * 获取所有的键值对
     *
     * @return 键值对集合
     */
    public List<Pair> pairSet() {
        List<Pair> list = new ArrayList<>();
        for (Pair pair : buckets) {
            if(pair != null) {
                list.add(pair);
            }
        }
        return list;
    }

    /**
     * 打印哈希表
     */
    public void print() {
        for (Pair kv : pairSet()) {
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }
    }
}

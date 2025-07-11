package main.java.datastructure.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * 链式地址哈希表
 *
 * @author yefeng
 */
public class HashMapChaining {
    /**
     * 键值对数量
     */
    private int size;

    /**
     * 哈希表容量
     */
    private int capacity;

    /**
     * 负载因子
     */
    private double loadFactor;
    /**
     * 扩容倍数
     */
    private int extendRatio;
    /**
     * 桶 数组
     */
    List<List<Pair>> buckets;

    public HashMapChaining() {
        size = 0;
        capacity = 16;
        loadFactor = 2.0 / 3.0;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
    }

    /**
     * 计算哈希值
     *
     * @param key 键
     * @return 哈希值
     */
    private int hash(int key) {
        return key % capacity;
    }

    /**
     * 获取负载因子
     */
    private double loadFactor() {
        return size * 1.0 / capacity;
    }

    /**
     * 获取值
     * @param key 键
     * @return 找到返回对应的 pair.getValue(), 否则返回 null
     */
    public String get(int key) {
        int hash = hash(key);
        List<Pair> pairs = buckets.get(hash);
        // 遍历桶, 若找到Key, 返回对应的值
        for (Pair pair : pairs) {
            if(pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return null;
    }

    /**
     * 添加元素
     * @param key key
     * @param value value
     */
    public void put(int key, String value) {
        if(loadFactor() > loadFactor) {
            extend();
        }
        int hash = hash(key);
        List<Pair> pairs = buckets.get(hash);
        // 遍历桶, 若找到Key, 则更新对应的值
        for (Pair pair : pairs) {
            if(pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        // 若无该 key ，则将键值对添加至尾部
        Pair pair = new Pair(key, value);
        pairs.add(pair);
        size++;
    }

    public void remove(int key) {
        int hash = hash(key);
        List<Pair> pairs = buckets.get(hash);
        // 遍历桶, 若找到Key, 则删除对应的键值对
        for (Pair pair : pairs) {
            if(pair.getKey() == key) {
                pairs.remove(pair);
                size--;
                return;
            }
        }
    }

    /**
     * 进行扩容
     */
    private void extend() {
        // 原来的桶
        List<List<Pair>> oldBucket = buckets;
        // 创建新的桶
        capacity = capacity * extendRatio;
        buckets = new ArrayList<>(capacity);
        // 初始化新桶
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
        // 遍历原来的桶, 将元素添加到新的桶中
        for (List<Pair> pairs : oldBucket) {
            for (Pair pair : pairs) {
                put(pair.getKey(), pair.getValue());
            }
        }
    }

}

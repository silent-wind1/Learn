package com.yefeng.structure.array;

import java.util.Iterator;

/**
 * @Author: 叶枫
 * @Date: 2025/04/25/12:55
 * @Description:
 */
public class ArraysList<T> implements Iterable<T>{
    private T[] value;

    private int size;

    private final int maxSize = 10;

    public ArraysList() {
        this.value = (T[]) new Object[maxSize];
        this.size = 0;
    }

    /**
     * 清空线性表
     */
    public void clear() {
        this.size = 0;
    }


    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.value[index];
    }


    /**
     * 根据参数newSize，重置value的大小
     * @param newSize 扩充大小
     */
    public void resize(int newSize) {
        // 定义一个临时数组，指向原数组
        T[] temp = value;
        // 创建新数组
        value = (T[]) new Object[newSize];
        // 把原数组的数据拷贝到新数组
        for (int i = 0; i < this.size; i++) {
            value[i] = temp[i];
        }
    }

    /**
     * 插入一个元素
     * @param t 元素
     */
    public void insert(T t) {
        if (this.size == this.maxSize) {
            this.resize(this.size * 2);
        }
        value[size] = t;
        this.size++;
    }

    /**
     * 指定下标插入元素
     * @param index 下标
     * @param t 元素
     */
    public void insert(int index, T t) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size == this.maxSize) {
            this.resize(this.size * 2);
        }
        for (int i = size; i > index; i--) {
            value[i] = value[i - 1];
        }
        value[index] = t;
        this.size++;
    }


    /**
     * 查找元素t是否在线性表中，如果在则返回下标
     * @param t 元素
     * @return 存在返回元素下标，不存在则返回-1
     */
    public int indexOf(T t) {
        for (int i = 0; i < size; i++) {
            if (value[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 通过下标删除元素
     * @param index 下标
     */
    public void delete(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1 ; i++) {
            value[i] = value[i + 1];
        }
        this.size--;
    }

    /**
     * 顺序表的遍历
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int cusor;

        public SIterator() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < size;
        }

        @Override
        public Object next() {
            return value[cusor++];
        }
    }
}

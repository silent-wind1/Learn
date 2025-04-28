package com.yefeng.structure.stack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 数组实现栈
 * @param <T>
 */
public class StackArray<T> implements Iterable<T>{
    private T[] stackArray; // 栈数组
    private int top = -1; // 栈顶
    private final int maxSize; // 最大值

    /**
     * 初始化
     * @param maxSize 最大值
     */
    public StackArray(int maxSize) {
        this.stackArray = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
    }

    /**
     * 栈满
     * @return 栈满返回 true，负责返回 false
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     * @return 栈空返回 true，负责返回 false
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 长度
     * @return 返回栈的长度
     */
    public int length() {
        return maxSize;
    }

    /**
     * 入栈
     * @param t 元素
     */
    public void push(T t) {
        // 如果栈满，进行扩容
        if(isFull()) {
            stackArray = Arrays.copyOf(stackArray, top * 2);
        }
        stackArray[++top] = t;
    }

    /**
     * 出栈
     * @return 返回栈顶元素
     */
    public T pop() {
        if(isEmpty()) {
            return null;
        }
        return stackArray[top--];
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator {
        private int curr;

        public SIterator() {
            this.curr = top;
        }

        @Override
        public boolean hasNext() {
            return curr > -1;
        }

        @Override
        public Object next() {
            return stackArray[curr--];
        }
    }
}

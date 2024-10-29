package main.java.datastructure.stack;

import java.util.Arrays;

public class MinStack {
    private Integer[] dataStack;
    private Integer[] minStack;
    private int top;
    private int min;


    public MinStack() {
        dataStack = new Integer[10];
        minStack = new Integer[10];
        top = -1;
        min = -1;
    }

    public void push(int val) {
        if (top == dataStack.length - 1) {
            extendStack();
        }
        dataStack[++top] = val;
        if (min < 0 || minStack[min] >= val) {
            minStack[++min] = val;
        }
    }

    public void pop() {
        if(dataStack[top].equals(minStack[min])) {
            min--;
        }
        top--;
    }

    public int top() {
        return dataStack[top];
    }

    public int getMin() {
        return minStack[min];
    }

    /**
     * 进行数组扩容
     */
    public void extendStack() {
        dataStack = Arrays.copyOf(dataStack, top * 2);
        minStack = Arrays.copyOf(minStack, top * 2);
    }
}

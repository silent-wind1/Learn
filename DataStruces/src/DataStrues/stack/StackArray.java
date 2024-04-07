package DataStrues.stack;

import java.util.Arrays;
import java.util.Iterator;

public class StackArray<T> implements Iterable<T>{
    private T[] stackArray; // 栈数组
    private int top = -1; // 栈顶
    private int maxSize; // 最大值

    /**
     * 初始化
     * @param maxSize
     */
    public StackArray(int maxSize) {
        this.stackArray = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
    }

    /**
     * 栈满
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 长度
     * @return
     */
    public int length() {
        return maxSize;
    }

    /**
     * 入栈
     * @param t
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
     * @return
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

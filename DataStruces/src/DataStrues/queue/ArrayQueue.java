package DataStrues.queue;

import java.util.Iterator;

public class ArrayQueue<T> implements Iterable<T>{
    private T[] queue;
    private int N;
    private int rear;  // 队尾
    private int front; // 队头

    public ArrayQueue(int n) {
        N = n;
        rear = front = -1;
        queue = (T[]) new Object[N];
    }

    /**
     * 长度
     * @return
     */
    public int length() {
        return N;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 判断队列是否满员
     * @return
     */
    public boolean isFull() {
        return rear == N;
    }

    /**
     * 添加元素
     * @param t
     */
    public void addQueue(T t) {
        if (isFull()) {
            return;
        }
        queue[++rear] = t;
    }

    public T popQueue() {
        if (isEmpty()) {
            return null;
        }

       return queue[++front];

    }

    public T getQueue() {
        if(isEmpty()) {
            return null;
        }
        return queue[front + 1];
    }

    @Override
    public Iterator<T> iterator() {
        return new IQueue();
    }

    private class IQueue implements Iterator {
        private int Node;

        public IQueue() {
            Node = front + 1;
        }

        @Override
        public boolean hasNext() {
            return Node < rear;
        }

        @Override
        public Object next() {
            return queue[Node++];
        }
    }
}

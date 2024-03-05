package DataStrues.ListTable;

import java.util.Iterator;

public class SequenceList<T> implements Iterable<T>, ListMethods<T> {
    private T[] listArray;
    private int N;

    /**
     * 初始化方法
     * @param capacity
     */
    public SequenceList(int capacity) {
        // 泛型是不能够实例化的，我们可以先使用Object类型在进行类型转换
        listArray = (T[]) new Object[capacity];
        N = 0;
    }

    /**
     * 清空线性表
     */
    public void clear() {
        this.N = 0;
    }

    /**
     * 判断线性表是否为空
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回线性表的长度
     * @return
     */
    public int length() {
        return N;
    }

    /**
     * 获取指定位置的元素
     * @param i
     * @return
     */
    public T get(int i) {
        return listArray[i];
    }

    /**
     * 向线性表中添加元素t
     * @param t
     */
    public void insert(T t) {
        if (N == listArray.length) {
            resize(listArray.length * 2);
        }
        listArray[N++] = t;
    }

    /**
     * 在i元素处插入元素t
     * @param i 索引
     * @param t 元素
     */
    public void insert(int i, T t) {
        if (N == listArray.length) {
            resize(listArray.length * 2);
        }
        for (int index = N; index > i; index--) {
            listArray[index] = listArray[index - 1];
        }
        listArray[i] = t;
        N++;
    }

    /**
     * 删除线性表中下标为i的元素
     *
     * @param i 索引
     * @return
     */
    public T remove(int i) {
        T current = listArray[i];
        for (int index = i; index < N - 1; index++) {
            listArray[index] = listArray[index + 1];
        }
        N--;
        // 如果N小于listArray长度四分之一那么将listArray长度减半
        if (N < listArray.length / 4) {
            resize(listArray.length / 2);
        }

        return current;
    }

    /**
     * 查找元素t是否在线性表中，如果在则返回下标
     * @param t
     * @return
     */
    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (listArray[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据参数newSize，重置listArray的大小
     * @param newSize
     */
    public void resize(int newSize) {
        // 定义一个临时数组，指向原数组
        T[] temp = listArray;
        // 创建新数组
        listArray = (T[]) new Object[newSize];
        // 把原数组的数据拷贝到新数组
        for (int i = 0; i < N; i++) {
            listArray[i] = temp[i];
        }
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
            return cusor < N;
        }

        @Override
        public Object next() {
            return listArray[cusor++];
        }
    }
}

package DataStrues.strand;

import java.util.Iterator;

public class ArrayStrand implements Iterable{
    private char[] data;
    private int maxSize; // 数组的初始长度
    private int N;  // 串的长度

    public ArrayStrand(int maxSize) {
        this.maxSize = maxSize;
        data = new char[maxSize];
        N = 0;
    }

    // 测试字符串的长度
    public int length() {
        return N;
    }

    // 将串t复制给当前串
    public void copy(ArrayStrand t) {
        // 如果当前字符串长度小于传递串的长度则扩容
        if (this.maxSize < t.maxSize) {
            this.maxSize = t.maxSize;
            this.data = new char[this.maxSize];
        }
        N = 0;
        for (int i = 0; i < t.length(); i++) {
            this.data[i] = t.data[i];
            this.N++;
        }
    }

    public boolean isEmpty() {
        return maxSize == 0;
    }

    // 字符串比较
    public int compare(ArrayStrand t) {
        int i = 0;
        // 将传递进来的串进行循环比较， 如果两个串的值相登并且没有超过t和data的长度 i++
        while (this.data[i] == t.data[i] && i < this.N && i < t.length()) {
            i++;
        }
        // i跟如果跟data和t长度相等，说明两个串相等
        if (i == this.N && i == t.length()) {
            return 0;
        }
        // 如果i等于t的长度，但是小于data串的长度，说明data串比t大
        if (i == t.length() && i < this.N) {
            return 1;
        }
        return -1;
    }

//    public int compare(char[] t) {
//        int i = 0;
//        // 将传递进来的串进行循环比较， 如果两个串的值相登并且没有超过t和data的长度 i++
//        while (this.data[i] == t[i] && i < this.N && i < t.length) {
//            System.out.println(i);
//            i++;
//        }
//        // i跟如果跟data和t长度相等，说明两个串相等
//        if (i == this.N && i == t.length) {
//            return 0;
//        }
//        // 如果i等于t的长度，但是小于data串的长度，说明data串比t大
//        if (i == t.length && i < this.N) {
//            return 1;
//        }
//        return -1;
//    }


    // 将指定串t连接到当前字符串
    public void concat(ArrayStrand t) {
        // 如果当前字符串最大长度 < N + length 则需要扩容
        if (this.maxSize < t.maxSize + t.length()) {
            char[] n = new char[this.N];
            for (int i = 0; i < this.N; i++) {
                n[i] = this.data[i];
            }
            // 扩展当前字符串容量
            this.maxSize = this.N + t.length();
            this.data = new char[this.maxSize];
            for (int i = 0; i < n.length; i++) {
                this.data[i] = n[i];
            }
        } else {
            for (int i = 0; i < t.length(); i++) {
                this.data[this.N] = t.data[i];
                this.N++;
            }
        }
    }

    // 对于一个顺序串求序号i开始长度为j的子串
    public ArrayStrand subString(int pos, int len) {
        if (pos + len >= this.N) {
            return null;
        }
        ArrayStrand t = new ArrayStrand(len);
        for (int k = 0; k < len; k++) {
            t.data[k] = this.data[pos + k];
            t.N++;
        }
        return t;
    }

    // 返回字符串t在当前中首次出现的位置，若不在返回-1
    public int index(ArrayStrand t) {
        if (this.N < t.length()) {
            return -1;
        }
        int index = -1; // 我将下标设置成-1默认就是没有找到
        for (int i = 0; i < N; i++) {
            int j = 0;
            while (j < t.length() && this.data[i + j] == t.data[j]) {
                if (this.data[i + j] != t.data[j]) {
                    break;
                }
                j++;
            }
            if(j == t.length()) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndex(ArrayStrand t) {
        return 0;
    }

    public int replace(ArrayStrand t, ArrayStrand v) {
        return 0;
    }


    public boolean insert(char t) {
        data[N++] = t;
        return true;
    }

    public boolean insert(char t, int pos) {
        if(pos > N) {
            return false;
        }

        for (int i = N - 1; i >= pos; i--) {
            data[i + 1] = data[i];
        }
        data[pos] = t;
        N++;
        return true;
    }

    public boolean delete(int pos, int n) {
        return false;
    }

    public boolean remove(ArrayStrand t) {
        return false;
    }
    // 将字符串中所有的字符转换为大写
    public void toUpperCase() {
        for (int i = 0; i < N; i++) {
            if(data[i] >= 'a' && data[i] < 'z') {
                data[i] -= 32;
            }
        }
    }
    // 将字符串中所有的字符转换为小写
    public void toLowerCase() {
        for (int i = 0; i < N; i++) {
            if(data[i] >= 'A' && data[i] < 'Z') {
                data[i] += 32;
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {
        private int node;

        public SIterator() {
            this.node = 0;
        }

        @Override
        public boolean hasNext() {
            return data[node] != 0;
        }

        @Override
        public Object next() {
            return data[node++];
        }
    }
}

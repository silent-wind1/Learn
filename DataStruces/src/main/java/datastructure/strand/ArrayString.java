package main.java.datastructure.strand;

public class ArrayString {
    private char[] string;
    private int N;
    private final int maxSize = 10;

    public ArrayString() {
        N = 0;
        this.string = new char[maxSize];
    }


    public int length() {
        return N;
    }

    public boolean clearArrayString() {
        string = null;
        N = 0;
        return true;
    }

    // 获取一个顺序串求序号i开始长度为j的子串
    public ArrayString subStr(int i, int j) {
        if (i < 0 || i >= N || i - j + 1 < 0 || i - j + 1 >= maxSize) {
            throw new IndexOutOfBoundsException();
        }
        ArrayString t = new ArrayString();
        t.N = j;
        for (int k = 0; k < j; k++) {
            t.string[k] = this.string[i + k];
        }
        return t;
    }

    // 字符串进行比较
    public int compare(ArrayString s, ArrayString t) {
        int i = 0;
        while(i < s.N && i < t.N) {
            if(s.string[i] != t.string[i]) {
                return s.string[i] - t.string[i];
            }
        }
        return s.N - t.N;
    }

    // 串连接操作
    public char[] concat(ArrayString s, ArrayString t) {
        if (s.N == 0 || t.N == 0) {
            return null;
        }
        char[] newStr = new char[s.N + t.N];
        int i;
        for (i = 0; i < s.N; i++) {
            newStr[i] = s.string[i];
        }
        for (int j = 0; j < t.N; j++) {
            newStr[i + j] = t.string[j];
        }
        return newStr;
    }
}

package com.demo7;

public class StringCount {
    public static void main(String[] args) {
        String str = "Hello Teachers My name is TangXi I'm 20 years old I like playing game and listen to the music";
        String sub = "My";
        System.out.println(Count(str, sub));
        int count = 0; // 统计出现次数
        int address = str.indexOf(sub); // 统计首次出现的次数
        while (true) {
            if (address != -1) {
                count++;
                address = str.indexOf(sub, address + sub.length()); // 以上一次出现的位置加持匹配项长度作为起始位置
            } else {
                break;
            }
        }
        System.out.println(count);
        // 也可以使用substring()调用使用
    }

    public static int Count(String ParentString, String SubString) {
        int count = 0;
        while (ParentString.contains(SubString)) { // 如果父串不包含子串循环结束
            count++; // 包含自增1
            // 调用substring(int beginIndex)方法，获取第一个相同的字符串出现后的字符串
            ParentString = ParentString.substring(ParentString.indexOf(SubString) + SubString.length());
        }
        return count;
    }
}

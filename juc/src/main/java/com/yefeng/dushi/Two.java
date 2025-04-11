package com.yefeng.dushi;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/17:24
 * @Description: 笃实科技笔试题第二题，考察点：字符串反转，并且将首字母大写
 */
public class Two {
    public static void main(String[] args) {
        String str = "scsod ot emoclew olleh";
        StringBuilder out = new StringBuilder();
        String[] arr = new StringBuilder().append(str).reverse().toString().split(" ");
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            // 将每个单词的首字母大写，后续单词拼接上
            out.append(arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1));
            if (i != len - 1) {
                out.append("_");
            }
        }
        // Hello_Welcome_To_Doscs
        System.out.println(out);
    }
}

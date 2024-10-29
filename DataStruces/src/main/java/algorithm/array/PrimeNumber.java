package main.java.algorithm.array;

import java.util.Arrays;

/**
 * @author 叶枫
 * @version 1.0
 * @date 2024/10/9 15:58
 * @description:
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int count = countPrimes(1000);
        System.out.println("素数一共有：" + count);
    }

    /**
     * @Author: 叶枫
     * @Date: 2024/10/9 15:58
     * @description: 统计素数
     * @version: 1.0
     */
    public static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;
        return count;
    }

}

package com.yefeng.demo;

import java.util.*;

public class DouniuCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示用户输入五张牌
        System.out.println("请输入五张牌（A=1，2-10, J=11, Q=12, K=13）：");
        int[] cards = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("输入第" + (i + 1) + "张牌：");
            String input = scanner.next();
            cards[i] = cardToValue(input); // 将牌面转换为对应的数值
        }

        // 计算牛的点数
        int result = calculateDouniu(cards);
        if (result == -1) {
            System.out.println("没有牛！");
        } else {
            System.out.println("牛的点数是: " + result);
        }
    }

    // 将牌面转换为对应的数值
    public static int cardToValue(String card) {
        switch (card.toUpperCase()) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(card);
        }
    }

    // 计算牛的点数，并展示每一步的公式
    public static int calculateDouniu(int[] cards) {
        // 打印输入的牌
        System.out.println("输入的五张牌的点数是: " + Arrays.toString(cards));

        // 使用List来存储所有的三张牌组合
        List<int[]> combinations = getCombinations(cards);

        // 计算每种组合
        for (int[] combination : combinations) {
            int sumOfThree = combination[0] + combination[1] + combination[2];
            System.out.println("选择三张牌： " + combination[0] + " + " + combination[1] + " + " + combination[2] + " = " + sumOfThree);

            // 如果三张牌的和能被10整除，说明是牛
            if (sumOfThree % 10 == 0) {
                // 计算剩下的两张牌
                int sumOfTwo = Arrays.stream(cards).sum() - sumOfThree;
                System.out.println("剩下两张牌的和是: " + sumOfTwo);
                System.out.println("牛的点数是: " + sumOfTwo % 10);
                return sumOfTwo % 10; // 返回剩余两张牌的点数作为牛的点数
            }
        }

        return -1; // 如果没有牛
    }

    // 获取所有可能的三张牌的组合
    public static List<int[]> getCombinations(int[] cards) {
        List<int[]> combinations = new ArrayList<>();

        // 使用简单的组合方法生成所有三张牌的组合
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    combinations.add(new int[]{cards[i], cards[j], cards[k]});
                }
            }
        }
        return combinations;
    }
}

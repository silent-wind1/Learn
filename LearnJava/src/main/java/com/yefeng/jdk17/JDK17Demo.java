package com.yefeng.jdk17;

/**
 * @Author: 叶枫
 * @Date: 2025/03/06/23:07
 * @Description:
 */
public class JDK17Demo {
    public static void main(String[] args) {
        String name = "JDK17Demo";
        formater(name);
//        switchFormater(name);

        String json = """
                {
                    "name": "Java",
                    "version": 17,
                    "features": [
                        "Sealed Classes",
                        "Pattern Matching"
                    ]
                }
                """;
        System.out.println(json);
    }

//    private static void switchFormater(Object obj) {
//        String result = switch (obj) {
//            case Integer i -> "整数: " + i;
//            case String s -> "字符串: " + s;
//            default -> "未知类型";
//        };
//        System.out.println(result);
//    }

    private static void formater(Object name) {
        String message = "Hello";
        if (name instanceof String s) {
            message = String.format("%s %s", message, name);
            System.out.println("s的长度 = " + s.length());
            System.out.println("s的名字 = " + s);
        }
        System.out.println(message);
    }
}

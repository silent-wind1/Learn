package com.yefeng.bishi.dushi;

/**
 * @Author: 叶枫
 * @Date: 2025/04/11/17:18
 * @Description: 笃实科技笔试题第一题, 考察点: 构造方法
 */
public class One {
    private String name;
    private int health;
    private String sex;
    public One() {
        this.sex = "熊";
    }
    public void  print() {
        System.out.println("name: " + name + " health: " + health + " sex: " + sex);
    }

    public static void main(String[] args) {
        One one = new One();
        one.print();
    }
}

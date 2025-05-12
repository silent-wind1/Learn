package com.yefeng.demo.data;

import lombok.Data;

/**
 * @Author: 叶枫
 * @Date: 2025/05/12/18:55
 * @Description:
 */
@Data
public class AbstractData {
    private String name;
    private String age;

    public AbstractData() {
        System.out.println("AbstractData");
    }

    public AbstractData(String name, String age) {
        System.out.println("AbstractData:" + name + age);
        this.name = name;
        this.age = age;
    }

    public void abstractShow() {
        System.out.println("AbstractData abstractShow --> 抽象方法");
    }

}

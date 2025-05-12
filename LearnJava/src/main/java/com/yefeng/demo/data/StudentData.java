package com.yefeng.demo.data;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 叶枫
 * @Date: 2025/05/12/18:56
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentData extends AbstractData{
    private String id;
    private String name;
    private String age;


    public StudentData() {
        System.out.println("StudentData");
    }

    public StudentData(String id, String name, String age) {
        super(name, age);
        System.out.println("StudentData:" + id + name + age);
    }

    public void abstractShow() {
        super.abstractShow(); // 调用父类的抽象方法
        System.out.println("StudentData  abstractShow --> 抽象方法");
    }
}

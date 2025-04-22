package com.yefeng.oriented;

/**
 * @Author: 叶枫
 * @Date: 2025/04/16/19:34
 * @Description:
 */
public class UserChildService extends UserServiceImpl implements UserService{
    public void printUser(String name) {
        System.out.println("我是孩子类: " + name);
        super.printUser(name);
    }
}

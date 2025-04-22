package com.yefeng.oriented;

/**
 * @Author: 叶枫
 * @Date: 2025/04/16/19:21
 * @Description:
 */
public class UserServiceImpl implements UserService{
    @Override
    public void printUser(String name) {
        System.out.println("用户名称为：" + name);
    }

    @Override
    public void addUser(String userName) {
        System.out.println("添加用户名称为：" + userName);
    }

    @Override
    public void updateUser(String name) {
        System.out.println("修改用户名称为：" + name);
    }
}

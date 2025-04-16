package com.yefeng.oriented;

/**
 * @Author: 叶枫
 * @Date: 2025/04/16/19:22
 * @Description:
 */
public class UserServiceTest {
    public static void main(String[] args) {
        UserService user = new UserServiceImpl();
        user.printUser("this is a book; we are family");
        user.addUser("我觉得富哥很强");
        user.updateUser("我觉得水哥也很强");
        AbsBaseUserService absBaseUserService = new UserServiceImpl();
        absBaseUserService.updateUser("I love you");
    }
}

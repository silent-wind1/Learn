package com.yefeng.oriented;

/**
 * @Author: 叶枫
 * @Date: 2025/04/16/19:21
 * @Description:
 */
public interface UserService extends BaseUserService, AbsBaseUserService{
    void addUser(String userName);
}

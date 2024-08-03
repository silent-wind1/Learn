package com.yefeng.constants;

/**
 * @Author: 叶枫
 * @Date: 2024/08/03/23:39
 * @Description:
 */
public enum UserLoginConstants {

    ACCOUNT_TYPE("ACCOUNT_TYPE"),
    PHONE_TYPE("PHONE_TYPE"),
    WEB_CHAT_TYPE("WEB_CHAT_TYPE");
    private final String name;

    UserLoginConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

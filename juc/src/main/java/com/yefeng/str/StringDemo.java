package com.yefeng.str;

import cn.hutool.core.util.StrUtil;

/**
 * @Author: 叶枫
 * @Date: 2025/03/24/21:03
 * @Description:
 */
public class StringDemo {
    public static void main(String[] args) {
        String businessLicenseName = "123";
        String creditCode = "123";
        // 校验营业执照和信用代码
        if (StrUtil.isEmpty(businessLicenseName) != StrUtil.isEmpty(creditCode)) {
            System.out.println("营业执照和信用代码必须同时存在或同时为空");
        } else {
            System.out.println("营业执照和信用代码校验通过");
        }
    }
}

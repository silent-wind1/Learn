package com.yefeng.str;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: 叶枫
 * @Date: 2025/03/24/21:03
 * @Description: 增加字符串演示以检查营业执照和信用代码
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
        // 查询合伙人，服务商，运营商是否都通过审核，如果都通过，则更新通过状态
        List<String> statuses = Arrays.asList("2", "2", "1");
        long countApproved = statuses.stream().filter("2"::equals).count();
        if (countApproved == 3) {
            System.out.println("审核通过");
        } else if (countApproved == 2 && statuses.contains("1")) {
            System.out.println("审核中");
        } else if (countApproved == 1) {
            System.out.println("待审核");
        }
    }

    /**
     * 获取当前登录用户的类型
     */
//    public String getCurrentUserType() {
//        LoginUser loginUser = SecurityUtils.getLoginUser();
//        if (loginUser == null) {
//            throw new RuntimeException("用户未登录");
//        }
//
//        String userType = loginUser.getUserType();
//
//        if ("01".equals(userType)) {
//            String company = ldsCompanyService.queryLoginCompany();
//            if (company == null || company.getType() == null) {
//                throw new RuntimeException("用工企业未关联有效公司信息");
//            }
//            return company.getType();
//        } else if ("04".equals(userType)) {
//            return userType;
//        }
//        throw new RuntimeException("未知用户类型: " + userType);
//    }
}

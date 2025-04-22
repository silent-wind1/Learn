package com.yefeng.jdk17.split;

public class SplitDemo {
    public static void main(String[] args) {
        String str = "lds_company-business_location_proof";
        String[] split = str.split("-");
        for (String s : split) {
            System.out.println(s);
        }

        String relation = "1"; // 发起方
        String type = "2"; // 公司类型
        if(!"2".equals(type) && !relation.equals(type)) {
            System.out.println("当前登录公司不是发起方，无法解绑");
        } else {
            System.out.println("当前登录公司是发起方，可以解绑");
        }
    }
}

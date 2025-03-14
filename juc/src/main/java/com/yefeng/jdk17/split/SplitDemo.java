package com.yefeng.jdk17.split;

public class SplitDemo {
    public static void main(String[] args) {
        String str = "lds_company-business_location_proof";
        String[] split = str.split("-");
        for (String s : split) {
            System.out.println(s);
        }
    }
}

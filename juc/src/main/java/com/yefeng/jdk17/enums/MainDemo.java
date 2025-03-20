package com.yefeng.jdk17.enums;

public class MainDemo {
    public static void main(String[] args) {
        String fileType = "businessLocationProof";
        FileTypeEnums fileTypeEnums = FileTypeEnums.getByFieldName(fileType);
        if (fileTypeEnums == null) {
            System.out.println("没有这个枚举类型");
        } else {
            System.out.println(fileTypeEnums.getTableFiledName());
        }
    }
}

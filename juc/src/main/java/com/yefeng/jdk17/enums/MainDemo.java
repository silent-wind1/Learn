package com.yefeng.jdk17.enums;

import static java.lang.System.exit;

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

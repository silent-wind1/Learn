package com.yefeng.refel;

import com.yefeng.refel.entity.Student;
import com.yefeng.refel.entity.Teacher;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author: 叶枫
 * @Date: 2025/02/24/22:14
 * @Description:
 */
public class reflectObject {
    public static void main(String[] args) {
        Student student = new Student("Alice", 25, "123 Main St");
        Teacher teacher = new Teacher("Alice", 26, "456 Elm St");
        // 定义字段映射
        Map<String, String> fieldMapping = new HashMap<>();
        fieldMapping.put("name", "fullName");
        fieldMapping.put("age", "yearsOld");
        fieldMapping.put("address", "location");

        Map<String, List<Object>> differences = compareFields(student, teacher, fieldMapping);

        System.out.println("字段差异:");
        differences.forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println();
        // 输出比较结果
//        for (Map.Entry<String, List<Object>> entry : differences.entrySet()) {
//            System.out.println("字段 '" + entry.getKey() + "' 不同: " + "源值 = " + entry.getValue().get(0) + ", 目标值 = " + entry.getValue().get(1));
//        }
    }


    /**
     * 比较两个对象的指定字段值（支持字段名映射）
     *
     * @param sourceObject 源对象
     * @param targetObject 目标对象
     * @param fieldMapping 字段映射表（key: 源对象的字段名, value: 目标对象的字段名）
     * @return Map<String, List < Object>> 记录不同的字段及它们的值
     */
    private static Map<String, List<Object>> compareFields(Object sourceObject, Object targetObject, Map<String, String> fieldMapping) {
        Map<String, List<Object>> differences = new HashMap<>();
        if (sourceObject == null || targetObject == null || fieldMapping == null || fieldMapping.isEmpty()) {
            return differences;
        }
        try {
            Class<?> sourceClass = sourceObject.getClass();
            Class<?> targetClass = targetObject.getClass();
            for (Map.Entry<String, String> entry : fieldMapping.entrySet()) {
                String sourceFieldName = entry.getKey();
                String targetFieldName = entry.getValue();
                try {
                    Field sourceField = sourceClass.getDeclaredField(sourceFieldName);
                    Field targetField = targetClass.getDeclaredField(targetFieldName);
                    sourceField.setAccessible(true);
                    targetField.setAccessible(true);
                    Object sourceValue = sourceField.get(sourceObject);
                    Object targetValue = targetField.get(targetObject);
                    if (!Objects.equals(sourceValue, targetValue)) {
                        differences.put(sourceFieldName, Arrays.asList(sourceValue, targetValue));
                    }
                } catch (NoSuchFieldException e) {
                    System.out.println("字段不存在" + sourceFieldName + "or" + targetFieldName);
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return differences;
    }
}

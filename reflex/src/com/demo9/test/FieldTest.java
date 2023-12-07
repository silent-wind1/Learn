package com.demo9.test;

import com.demo9.pojo.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 */
public class FieldTest {
    @Test
    public void test1() {
        Class clazz = Person.class;
        // 获取属性结构
        // getFields(): 获取当前运行时类及其父类声明中为public访问权限属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        // getDeclaredFields(): 获取当前运行时类中声明的所有属性。（不包含父类声明中的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
    // 修饰符 数据类型 变量名
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // 数据类型
            Class<?> type = field.getType();
            System.out.print(type.getName() + " \t");

            // 变量名
            String name = field.getName();
            System.out.print(name + "\t");
            System.out.println();
        }
    }
}

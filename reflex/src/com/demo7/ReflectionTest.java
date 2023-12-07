package com.demo7;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
//      1. 调用运行时类的属性.class
        Class<Person> clazz = Person.class;
        System.out.println(clazz);
//       2.通过运行时类的对象，调用getClass()
        Person person = new Person();
        Class clazz1 = person.getClass();
        System.out.println(clazz1);
//       3. 调用Class的静态方法：forName(String classPath)
        Class class3 = Class.forName("com.demo7.Person");
        System.out.println(class3);
        System.out.println(clazz == clazz1);
        System.out.println(clazz == class3);

    }
}

class Person {
    private String name;
    private String age;

    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private void show() {
        System.out.println("我是一个私有方法，不能被调用oh");
    }
}

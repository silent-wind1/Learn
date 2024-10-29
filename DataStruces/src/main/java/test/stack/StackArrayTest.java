package main.java.test.stack;

import main.java.datastructure.stack.StackArray;

public class StackArrayTest {
    public static void main(String[] args) {
        StackArray<String> stack = new StackArray<>(5);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("B");
        stack.push("W");
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println("--------------------");
        System.out.println(stack.length());
        System.out.println("stack = " + stack.isFull());
        System.out.println("---------------------");
        System.out.println(stack.pop());
    }
}

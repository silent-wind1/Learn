package main.java.test.stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println("------------------");
        String pop = stack.pop();
        System.out.println("弹出栈" + pop);
        System.out.println(stack.size());
    }
}

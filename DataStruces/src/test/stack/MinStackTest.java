package test.stack;

import DataStrues.stack.MinStack;


public class MinStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println("minStack = " + minStack.getMin());
        minStack.pop();
        System.out.println("minStack.top() = " + minStack.top());
        System.out.println("minStack = " + minStack.getMin());
    }
}

package main.java.test.stack;

import main.java.datastructure.stack.StackLink;

public class ReversePolishNotationTest {
    public static void main(String[] args) {
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = caculate(notation);
        System.out.println("result = " + result);
    }

    /**
     * 逆波兰表达式
     * @param notation
     * @return
     */
    public static int caculate(String[] notation) {
        StackLink<Integer> stack = new StackLink<>();
        Integer number1;
        Integer number2;
        for (int i = 0; i < notation.length; i++) {
            if(notation[i].equals("+")) {
                number1 = stack.pop();
                number2 = stack.pop();
                stack.push(number2 + number1);
            }else if(notation[i].equals("-")) {
                number1 = stack.pop();
                number2 = stack.pop();
                stack.push(number2 - number1);
            }else if(notation[i].equals("*")) {
                number1 = stack.pop();
                number2 = stack.pop();
                stack.push(number2 * number1);
            }else if(notation[i].equals("/")) {
                number1 = stack.pop();
                number2 = stack.pop();
                stack.push(number2 / number1);
            }else{
                stack.push(Integer.parseInt(notation[i]));
            }
        }
        return stack.pop();
    }
}

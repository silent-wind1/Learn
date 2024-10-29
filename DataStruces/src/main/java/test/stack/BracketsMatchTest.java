package main.java.test.stack;

import main.java.datastructure.stack.StackLink;

/**
 * 使用栈解决括号匹配问题
 */
public class BracketsMatchTest {
    public static void main(String[] args) {
        String name = ")(yefeng)(";

        System.out.println("name = " +  isMatch(name));
    }

    public static boolean isMatch(String str) {
        StackLink<String> stack = new StackLink<>();
        for (int i = 0; i < str.length(); i++) {
            String s = str.charAt(i) + "";
            if(s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                String pop = stack.pop();
                if(pop == null) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}

package Recursion.Question;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        return eval(s);
    }

    public int eval(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        s = s.replaceAll(" ", ""); // remove spaces

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int result = 0;
        for (int val : stack) result += val;
        return result;
    }


}
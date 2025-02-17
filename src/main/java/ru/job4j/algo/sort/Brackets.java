package ru.job4j.algo.sort;

import java.util.Stack;

public class Brackets {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char r = stack.pop();
                if ((c == ')' && r != '(') || (c == ']' && r != '[') || (c == '}' && r != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

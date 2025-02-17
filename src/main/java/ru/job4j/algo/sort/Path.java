package ru.job4j.algo.sort;

import java.util.Stack;

public class Path {

    public String simplify(String path) {
        var stack = new Stack<>();
        var components = path.split("/");
        for (var component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }
        var result = new StringBuilder();
        for (Object dir : stack) {
            result.append("/").append(dir);
        }
        return !result.isEmpty() ? result.toString() : "/";
    }

    public static void main(String[] args) {
        String str = "../../file.txt";
        Path path = new Path();
        System.out.println(path.simplify(str));
    }
}

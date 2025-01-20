package ru.job4j.tasks;

public class Task173 {

    public static String code(String s) {

        if (s.length() == 0) {
            return "empty";
        }
        if (s.length() > 0 && s.length() <= 4) {
            return s;
        }

        char[] str = s.toCharArray();

        for (int i = 0; i < str.length - 4; i++) {
            str[i] = '#';
        }

        return String.valueOf(str);
    }

    public static void main(String[] args) {
        String s = "123456789";
        System.out.println(code(s));
    }
}

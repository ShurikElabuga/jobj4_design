package ru.job4j.algo.hash;

import java.util.HashMap;

public class LongestUniqueSubstring {

    public static String longestUniqueSubstring(String str) {
        HashMap<Character, Integer> substr = new HashMap<>();
        String result = "";
        int i = 0;
        for (int j = 0; j < str.length(); j++) {
            char current = str.charAt(j);
            if (substr.containsKey(current)) {
                i = Math.max(substr.get(current) + 1, i);
            }
            substr.put(current, j);
            if (j - i + 1 > result.length()) {
                result = str.substring(i, j + 1);
            }
        }
        return result;
    }
}

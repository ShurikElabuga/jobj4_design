package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {

        int[] result = new int[2];
        int i = 0;
        int j = 1;
        int n = k;
        while (nums[i] < nums.length) {
            if (nums[j] != nums[i]) {
                n--;
                if (n == 1) {
                    result[0] = j + 1 - k;
                    result[1] = j;
                    break;
                }
                i++;
                j++;
            } else if ((nums.length - i) >= k) {
                i++;
                j++;
                n = k;
            } else {
                return null;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}

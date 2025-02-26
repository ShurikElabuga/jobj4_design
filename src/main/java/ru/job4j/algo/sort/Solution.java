package ru.job4j.algo.sort;

import java.util.Arrays;

public class Solution {

    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        return maxGap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 6, 10, 1};
        System.out.println(solution.maximumGap(nums));
    }
}

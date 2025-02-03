package ru.job4j.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class IntervalMerger {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            List<int[]> arrayList = new ArrayList<>();
            int[] currentInterval = intervals[0];
            arrayList.add(currentInterval);
            for (int[] interval : intervals) {
                int currentEnd = currentInterval[1];
                int nextStart = interval[0];
                int nextEnd = interval[1];
                if (currentEnd >= nextStart) {
                    currentInterval[1] = Math.max(currentEnd, nextEnd);
                } else {
                    currentInterval = interval;
                    arrayList.add(currentInterval);
                }
            }
            int[][] result = new int[arrayList.size()][2];
            return arrayList.toArray(result);
        }
    }

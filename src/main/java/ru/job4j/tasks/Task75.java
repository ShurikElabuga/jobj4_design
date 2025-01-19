package ru.job4j.tasks;

public class Task75 {

    public static void array(int[] arr) {
        int[] counts = new int[10]; /*Индексы соответствуют цифрам от 0 до 9*/
        for (int num : arr) {
            counts[num]++;
        }

        StringBuilder firstLine = new StringBuilder();
        int length = 0;
        for (int i = 1; i <= 9; i++) {
            if (counts[i] > 1) {
                length++;
            }
            firstLine.append(i).append(": ").append(counts[i]).append(", ");
        }
        firstLine.delete(firstLine.length() - 2, firstLine.length()); /*Удаляем запятую и пробел в конце*/

        int maxCount = 0;
        int minCount = 9;

        for (int count : counts) {
            maxCount = Math.max(maxCount, count);

            if (count != 0) {
                minCount = Math.min(minCount, count);
            }
        }

        StringBuilder mostFrequent = new StringBuilder();
        StringBuilder leastFrequent = new StringBuilder();
        StringBuilder absent = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            if (counts[i] == maxCount && maxCount > 0 && maxCount != 1 && length > 1) {
                mostFrequent.append(i).append(" ");
            }
            if (counts[i] == 0) {
                absent.append(i).append(" ");
            }
            if (counts[i] == minCount && length > 1) {
                leastFrequent.append(i).append(" ");
            }
        }

        if (mostFrequent.length() == 0) {
            mostFrequent.append("0");
        } else {
            mostFrequent.deleteCharAt(mostFrequent.length() - 1);
        }
        if (absent.length() == 0) {
            absent.append("0");
        } else {
            absent.delete(absent.length() - 1, absent.length());
        }
        if (leastFrequent.length() == 0) {
            leastFrequent.append("0");
        } else {
            leastFrequent.deleteCharAt(leastFrequent.length() - 1);
        }

        System.out.println(firstLine);
        System.out.println("Чаще: " + mostFrequent + ", отсутствует: " + absent + ", реже: " + leastFrequent);
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 2, 2, 3, 3, 4, 5};
        array(numbers1);
        System.out.println("_______________________________________");
        int[] numbers2 = {3, 2, 2, 1, 1};
        array(numbers2);
        System.out.println("_______________________________________");
        int[] num3 = {1, 1};
        array(num3);
        System.out.println("_______________________________________");
        int[] num4 = {1, 2, 2, 4, 5, 2, 7, 8, 7};
        array(num4);
        System.out.println("_______________________________________");
        int[] num5 = {2, 1, 3, 5, 6, 4, 9, 7, 8};
        array(num5);
        System.out.println("_______________________________________");
        int[] num7 = {1, 1, 1};
        array(num7);
        System.out.println("_______________________________________");
        int[] num6 = {2, 1};
        array(num6);
    }
}

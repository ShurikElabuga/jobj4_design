package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        File fileCSV = new File(argsName.get("path"));
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String[] filter = argsName.get("filter").split(",");

        Scanner scan = new Scanner(new FileInputStream(fileCSV));
        List<String> strings = new ArrayList<>();

        while (scan.hasNextLine()) {
            strings.add(scan.nextLine());
        }
        scan.close();

        List<Integer> indexList = new ArrayList<>();
        int index;
        for (String f : filter) {
            if (strings.get(0).contains(f)) {
                String[] arrays = strings.get(0).split(delimiter);
                index = Arrays.asList(arrays).indexOf(f);
                indexList.add(index);
            }
        }

        List<String> list = new ArrayList<>();
        for (String str : strings) {
            String[] lines = str.split(delimiter);
            StringBuilder builder = new StringBuilder();
            for (Integer i : indexList) {
                builder.append(lines[i]).append(delimiter);
            }
            list.add(builder.substring(0, builder.length() - 1));
        }

        if ("stdout".equals(out)) {
            for (String str : list) {
                System.out.println(str);
            }
        } else {
            File fileOut = new File(out);
            try (PrintStream printStream = new PrintStream(fileOut)) {
                for (String str : list) {
                    printStream.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("The number of args must be 4");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}

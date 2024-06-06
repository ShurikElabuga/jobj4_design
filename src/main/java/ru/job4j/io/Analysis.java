package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))
             ) {
            String line;
            int work = 200;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ", 2);
                String status = words[0];
                String date = words[1] + ";";
                boolean start = status.equals("400") || status.equals("500");
                if (start) {
                    if (work == 400) {
                        continue;
                    }
                    writer.write(date);
                    work = 400;
                } else {
                    if (work == 400) {
                        writer.write(date + "\n");
                        work = 200;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}

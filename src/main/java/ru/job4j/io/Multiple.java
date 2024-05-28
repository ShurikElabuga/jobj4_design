package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Multiple {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/multiple.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    String str = Integer.toString(i * j);
                    output.write(str.getBytes());
                    output.write(" ".getBytes());
                }
                output.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

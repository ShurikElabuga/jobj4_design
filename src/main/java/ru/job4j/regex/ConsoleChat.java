package ru.job4j.regex;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private String getRandomLine(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Random random = new Random();
        return lines.get(random.nextInt(lines.size()));
    }

    public void run() {
        readPhrases();
        Scanner console = new Scanner(System.in);
        System.out.println("Напишите что-нибудь: ");
        String phrase;
        List<String> log = new ArrayList<>();
        boolean cycle = true;
        boolean dialog = true;
        while (cycle) {
            phrase = console.nextLine();
            log.add(phrase);
            switch (phrase) {
                case OUT -> {
                    System.out.println("Программа закончила работу.");
                    saveLog(log);
                cycle = false;
                }
                case STOP -> {
                    System.out.println("Помолчу...");
                    dialog = false;
                }
                case CONTINUE -> {
                    System.out.println("Продолжаем...");
                    String answer = getRandomLine(botAnswers);
                    System.out.println(answer);
                    log.add(answer);
                    dialog = true;
                }
                default -> {
                    if (dialog) {
                        String answer = getRandomLine(botAnswers);
                        System.out.println(answer);
                        log.add(answer);
                    }
                }
            }
        }
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines()
                    .map(string -> string + System.lineSeparator())
                    .forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
        log.forEach(writer::println);
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/logFile.txt", "data/AnswersOfBot.txt");
        consoleChat.run();
    }
}

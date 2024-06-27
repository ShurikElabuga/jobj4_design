package ru.job4j.io;

import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        checkArgs(args);
        File start = new File(args[0]);
        search(start.toPath(), path -> path.toFile().getName()
                .endsWith(args[1])).forEach(System.out::println);
    }

    public static void checkArgs(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Enter two parameters.");
        }
        if (!".".equals(args[0])) {
            throw new IllegalArgumentException("Root folder is not valid");
        }
        if (!".js".equals(args[1])) {
            throw new IllegalArgumentException("File extension is not correct");
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

}

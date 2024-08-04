package ru.job4j.finder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FilesFinder {
    public static void main(String[] args) throws IOException {

        checkArgsFinder(args);
        ArgsName argsName = ArgsName.of(args);
        List<Path> list = searchFinder(argsName);
        writeFiles(list, argsName);

    }


    public static void checkArgsFinder(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Enter four parameters.");
        }
    }

    private static String converterMaskToRegex(String arg) {
        return arg.replace("*", "\\S*")
                .replace("?", "\\S{1}")
                .replace(".", "\\.");
    }

    public static Predicate<Path> definationPredicate(ArgsName argsName) {
        Predicate<Path> predicate = null;
        if ("name".equals(argsName.get("t"))) {
            predicate = path -> path.getFileName().toFile().toString().equals(argsName.get("n"));
        } else if ("mask".equals(argsName.get("t"))) {
            predicate = path -> path.getFileName().toFile().toString()
                    .matches(converterMaskToRegex(argsName.get("n")));
        } else if ("regex".equals(argsName.get("t"))) {
            Pattern pattern = Pattern.compile(argsName.get("n"));
            predicate = path -> pattern.matcher(path.getFileName().toString()).matches();
        }
        return predicate;
    }

    public static List<Path> searchFinder(ArgsName argsName) throws IOException {
        Path root = Path.of(argsName.get("d"));
        SearchFileSource searcher = new SearchFileSource(definationPredicate(argsName));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void writeFiles(List<Path> files, ArgsName argsName) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(argsName.get("o")))) {
            for (Path path : files) {
                out.write(path + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

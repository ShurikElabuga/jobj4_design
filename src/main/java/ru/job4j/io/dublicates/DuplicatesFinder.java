package ru.job4j.io.dublicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        Map<FileProperty, List<Path>> mapFiles = findFiles(start);
        printDuplicates(mapFiles);
    }
    public static Map<FileProperty, List<Path>> findFiles(Path root) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(root, duplicatesVisitor);
        return duplicatesVisitor.getFiles();
    }

    public static void printDuplicates(Map<FileProperty, List<Path>> map) {
        for (Map.Entry<FileProperty, List<Path>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getKey().getName() + " - " + entry.getKey().getSize() + "Mb");
                for (Path path : entry.getValue()) {
                    System.out.println(path);
                }
            }
        }

    }
}

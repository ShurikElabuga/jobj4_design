package ru.job4j.io.dublicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, List<Path>> files = new HashMap<>();


    public Map<FileProperty, List<Path>> getFiles() {
        return files;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        Path path = file.toAbsolutePath();
        List<Path> value = new ArrayList<>();
        if (!files.containsKey(fileProperty)) {
            value.add(path);
            files.put(fileProperty, value);
        } else {
            value = files.get(fileProperty);
            value.add(path);
            files.put(fileProperty, value);
        }
        return super.visitFile(file, attrs);
    }
}

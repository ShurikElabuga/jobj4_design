package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(target))) {
            for (Path path : sources) {
                out.putNextEntry(new ZipEntry(path.toString()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    out.write(output.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void validateArgs(ArgsName args) {
        File file = new File(args.get("d"));
        if (!file.exists()) {
            throw new IllegalArgumentException("File doesn't exist!");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Directory doesn't exist!");
        }
        String extension = args.get("e");
        if (!extension.startsWith(".")) {
            throw new IllegalArgumentException("File extension must start with '.'.");
        }
        String zipExtension = args.get("o");
        if (!zipExtension.endsWith(".zip")) {
            throw new IllegalArgumentException("Zip-file extension must ends with '.zip'.");
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        Zip zip = new Zip();
        ArgsName argsName = ArgsName.of(args);
        validateArgs(argsName);
        Path startPath = Paths.get(argsName.get("d"));
        List<Path> sources = Search.search(startPath, path -> path.toFile().getName()
                .endsWith(argsName.get("e")));
        File fileTarget = new File(argsName.get("o"));
        zip.packFiles(sources, fileTarget);

    }
}

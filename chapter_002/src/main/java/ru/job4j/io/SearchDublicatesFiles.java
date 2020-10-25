package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.nio.file.FileVisitResult.CONTINUE;
//change
public class SearchDublicatesFiles implements FileVisitor<Path> {
    Map<Path, Long> storage;
    Set<Path> resultPath;

    public SearchDublicatesFiles() {
        storage = new HashMap<>();
        resultPath = new HashSet<>();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (storage.containsKey(file.getFileName()) && storage.get(file.getFileName()) == file.toFile().getTotalSpace()) {
            resultPath.add(file);
        } else {
            storage.put(file.getFileName(), file.toFile().getTotalSpace());
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public Set<Path> getResultPath() {
        return resultPath;
    }

}

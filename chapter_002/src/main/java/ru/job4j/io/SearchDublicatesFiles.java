package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.nio.file.FileVisitResult.CONTINUE;
//change
public class SearchDublicatesFiles extends SimpleFileVisitor<Path> {
    private Map<Path, Long> storage;
    private Set<Path> resultPath;

    public SearchDublicatesFiles() {
        storage = new HashMap<>();
        resultPath = new HashSet<>();
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (storage.containsKey(file.getFileName()) && storage.get(file.getFileName()) == file.toFile().length()) {
        resultPath.add(file);
        } else {
            storage.put(file.getFileName(), file.toFile().length());
        }
        return super.visitFile(file, attrs);
    }

    public Set<Path> getResultPath() {
        return resultPath;
    }

}


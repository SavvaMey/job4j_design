package ru.job4j.io.searchFilesinDirectory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFileAlg extends SimpleFileVisitor<Path> {
    private Predicate<Path> predicate;
    private List<Path> paths;

    public SearchFileAlg(Predicate<Path> predicate) {
        paths = new ArrayList<>();
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {
        if (predicate.test(file)) {
            paths.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getPaths() {
        return paths;
    }
}

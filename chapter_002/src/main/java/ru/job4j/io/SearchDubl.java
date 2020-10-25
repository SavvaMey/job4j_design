package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
//change
public class SearchDubl {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start).forEach(System.out::println);
    }

    public static Set<Path> search(Path root) throws IOException {
        SearchDublicatesFiles searcher = new SearchDublicatesFiles();
        Files.walkFileTree(root, searcher);
        return searcher.getResultPath();
    }
}

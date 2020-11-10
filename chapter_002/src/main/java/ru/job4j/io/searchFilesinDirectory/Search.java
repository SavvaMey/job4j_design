package ru.job4j.io.searchFilesinDirectory;

import ru.job4j.io.SearhZip;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Search {

    public static List<Path> search(Path root, Predicate<Path> predicate) throws IOException {
        SearchFileAlg searcher = new SearchFileAlg(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void save(List<Path> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            log.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Predicate<Path> createPredicate (String name, String type) {
        Predicate<Path> predicate = path -> path.getFileName().toString().equals(name);
        switch (type) {
            case "r":
                Pattern pattern = Pattern.compile(name);
                predicate = path -> pattern.matcher(path.getFileName().toString()).find();
                break;
            case "f":
               break;
            case "m":
                String fileName = name.replace("*", "");
                predicate = path -> path.getFileName().toString().contains(fileName);
                break;
        }
        return predicate;
    }

    public static void main(String[] args) throws IOException {
        // -d C:\Users\savva\IdeaProjects -n *.xml -m -o log.txt
        ArgSearch arg = new ArgSearch(args);
        if (!arg.valid()) {
            return;
        }
        Predicate<Path> predicate = createPredicate(arg.name(), arg.type());
        Path start = Paths.get(arg.directory());
        List<Path> files = search(start, predicate);
        save(files, arg.output());
    }
}

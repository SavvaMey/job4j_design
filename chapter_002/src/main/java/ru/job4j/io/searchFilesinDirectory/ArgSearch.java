package ru.job4j.io.searchFilesinDirectory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// java -jar find.jar -d c:/ -n *.txt -m -o log.txt
public class ArgSearch {
    private final String[] args;
//    private final Map<String, String> values = new HashMap<>();

    public ArgSearch(String[] args) {
        this.args = args;
        valid();
    }

    public boolean valid() {
        if (args.length != 7) {
            throw new IllegalArgumentException("Wrong ARGS");
        }
        return true;
    }

    public String directory() {
        return args[1];
    }

    public String name() {
        return args[3];
    }

    public String type() {
        return args[4].substring(1);
    }

    public String output() {
        return args[6];
    }
}

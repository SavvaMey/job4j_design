package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgZip {
    private final String[] args;
    private final Map<String, String> values = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
        valid();
    }

    public boolean valid() {
        if (args.length < 3) {
            throw new IllegalArgumentException("Wrong ARGS");
        }
        Arrays.stream(args).forEach(
                data -> this.values.put(
                        data.split("=")[0].substring(1), data.split("=")[1]));
        return values.get("d") != null && values.get("o") != null;
    }

    public String directory() {
        return values.get("d");
    }

    public String exclude() {
        return values.get("e");
    }

    public String output() {
        return values.get("o");
    }
}

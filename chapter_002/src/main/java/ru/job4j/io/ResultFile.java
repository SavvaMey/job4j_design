package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                s.append(i * j).append("\t");
            }
            s.append(System.lineSeparator());
        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(s.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

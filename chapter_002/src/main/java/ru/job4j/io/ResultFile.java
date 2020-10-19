package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static void main(String[] args) {
        String s = "";
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                s += (i * j) + "\t";
            }
            s += "\n";
        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(s.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

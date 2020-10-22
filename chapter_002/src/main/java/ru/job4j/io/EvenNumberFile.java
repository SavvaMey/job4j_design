package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                StringBuilder out = new StringBuilder();
                int testNumber = Integer.parseInt(String.valueOf(line));
                if (testNumber % 2 == 0) {
                    out.append(testNumber).append(" even");
                } else {
                    out.append(testNumber).append(" odd");
                }
                System.out.println(out);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

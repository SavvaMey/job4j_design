package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultFile {
    public static void OutputFunction() {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < 15000; i++) {
            s.append("London is the capital of great Britain. " +
                    "I am travelling down the river.");
            s.append(System.lineSeparator());
        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(s.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        try (PrintWriter out = new PrintWriter(
//                new BufferedOutputStream(
//                        new FileOutputStream("result.txt")
//                ))) {
//           out.write(String.valueOf(s));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void InputFunction() {
        try (BufferedReader in = new BufferedReader(
                new FileReader("result.txt"))) {
            List<String> lines = new ArrayList<>();
            in.lines().forEach(lines::add);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        OutputFunction();
        InputFunction();
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        //        StringBuilder s = new StringBuilder();
//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                s.append(i * j).append("\t");
//            }
//            s.append(System.lineSeparator());
//        }
//        try (FileOutputStream out = new FileOutputStream("result.txt")) {
//            out.write(s.toString().getBytes());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

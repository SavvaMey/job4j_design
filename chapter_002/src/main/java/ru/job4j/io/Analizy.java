package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String s;
            boolean serverFall = false;
            while ((s = in.readLine()) != null) {
                String[] line = s.split(" ");
                if (!serverFall) {
                    if (line[0].equals("400") || line[0].equals("500")) {
                        result.append(line[1]).append(";");
                        serverFall = true;
                    }
                }
                if (serverFall) {
                    if (!line[0].equals("400") && !line[0].equals("500")) {
                        result.append(line[1]).append(";")
                                .append(System.lineSeparator());
                        serverFall = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            out.write(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

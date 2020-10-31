package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public String getBotAnswer() {
        String answer = "";
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            List<String> answers = new ArrayList<>();
            in.lines().forEach(answers::add);
            answer = answers.get((int) (Math.random() * answers.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }

    public void run() {
        boolean running = true;
        boolean stop = false;
            try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                 PrintWriter out = new PrintWriter(
                         new BufferedOutputStream(
                                 new FileOutputStream(path)
                         ))) {
                while (running) {
                String input = consoleReader.readLine();
                String bot = getBotAnswer();
                if (input.equals(OUT)){
                    running = false;
                    out.write(input + System.lineSeparator());
                } else if (input.equals(STOP)) {
                    stop = true;
                    out.write(input + System.lineSeparator());
                } else if (stop && input.equals(CONTINUE)) {
                    stop = false;
                }
                if (!stop && running) {
                    System.out.println(bot);
                    out.write(input + System.lineSeparator()
                            + bot + System.lineSeparator());
                }
            }
        } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./chapter_002/src/data/log.txt",
                "./chapter_002/src/data/text.txt");
        cc.run();
    }
}

package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
//    @Test
//    public void whenAnalizy() throws IOException {
//        Analizy analyzy = new Analizy();
//        analyzy.unavailable("./data/server.log", "./data/result.log");
//        BufferedReader reader = new BufferedReader(new FileReader("./data/result.log"));
//        assertThat(reader.readLine(), is("10:58:01;10:59:01;"));
//        assertThat(reader.readLine(), is("11:01:02;11:02:02;"));
//        assertThat(reader.readLine(), is(nullValue()));
//    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("serverTemp.log");
        File target = folder.newFile("resultTemp.log");
        Analizy analyzy = new Analizy();
        try (PrintWriter out = new PrintWriter(source)) {
            out.write("200 10:56:01\n"
                    + "200 10:57:01\n"
                    + "400 10:58:01\n"
                    + "200 10:59:01\n"
                    + "500 11:01:02\n"
                    + "200 11:02:02");
        }
        analyzy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        BufferedReader reader = new BufferedReader(new FileReader(target));
        assertThat(reader.readLine(), is("10:58:01;10:59:01;"));
        assertThat(reader.readLine(), is("11:01:02;11:02:02;"));
        assertThat(reader.readLine(), is(nullValue()));
    }
}
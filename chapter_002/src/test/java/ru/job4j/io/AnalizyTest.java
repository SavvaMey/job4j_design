package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Test
    public void whenAnalizy() throws IOException {
        Analizy analyzy = new Analizy();
        analyzy.unavailable("./data/server.log", "./data/result.log");
        BufferedReader reader = new BufferedReader(new FileReader("./data/result.log"));
        assertThat(reader.readLine(), is("10:58:01;10:59:01;"));
        assertThat(reader.readLine(), is("11:01:02;11:02:02;"));
        assertThat(reader.readLine(), is(nullValue()));
    }
}
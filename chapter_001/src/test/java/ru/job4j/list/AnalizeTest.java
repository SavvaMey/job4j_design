package ru.job4j.list;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void diffFullTest() {
        Analize.User userF = new Analize.User(1, "Sav");
        Analize.User userT = new Analize.User(2, "Max");
        Analize.User userM = new Analize.User(3, "Stas");
        List<Analize.User> previous = List.of(userF, userM, userT);
        Analize.User userK = new Analize.User(1, "Kir");
        Analize.User userS = new Analize.User(5, "Kim");
        List<Analize.User> current = List.of(userK, userT, userS);
        Analize.Info info = Analize.diff(previous,current);
        assertEquals(info, new Analize.Info(1,1,1));
    }

    @Test
    public void diffAllDeleted() {
        List<Analize.User> previous = List.of(
                new Analize.User(1, "Sav"),
                new Analize.User(2, "Max"),
                new Analize.User(3, "Stas")
        );
        List<Analize.User> current = List.of();
        Analize.Info info = Analize.diff(previous,current);
        assertEquals(info, new Analize.Info(0,0,3));
    }
}
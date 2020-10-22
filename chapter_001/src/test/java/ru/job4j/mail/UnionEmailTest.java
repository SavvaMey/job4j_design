package ru.job4j.mail;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UnionEmailTest {
    @Test
    public void testUnion() {
        Map<String, Set<String>> users = new HashMap<>();
        users.put("user1", new HashSet<>(Set.of("xxx@ya.ru",
                "foo@gmail.com", "lol@mail.ru")));
        users.put("user2", new HashSet<>(Set.of("foo@gmail.com", "ups@pisem.net")));
        users.put("user3", new HashSet<>(Set.of("xyz@pisem.net", "vasya@pupkin.com")));
        users.put("user4", new HashSet<>(Set.of("ups@pisem.net", "aaa@bbb.ru")));
        users.put("user5", new HashSet<>(Set.of("xyz@pisem.net")));
        users.put("user6", new HashSet<>(Set.of("vasya@pupkin.com", "aaa@bbb.ru", "ups@pisem")));
        users.put("user7", new HashSet<>(Set.of("vasya@pupkin.com", "aaa@bbb.ru", "ups@pisem")));
        users.put("user8", new HashSet<>(Set.of("vasya@pupkin.com")));
        Map<String, Set<String>> usersNew = UnionEmail.merge(users);
        assertEquals(3, usersNew.size());
    }

    @Test
    public void testIdentUnion() {
        Map<String, Set<String>> users = new HashMap<>();
        users.put("user1", new HashSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        users.put("user2", new HashSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        users.put("user3", new HashSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        users.put("user4", new HashSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        users.put("user5", new HashSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        users.put("user6", new HashSet<>(Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru")));
        Map<String, Set<String>> usersNew = UnionEmail.merge(users);
        assertEquals(1, usersNew.size());
    }
}
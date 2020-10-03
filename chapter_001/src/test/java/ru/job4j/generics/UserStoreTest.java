package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void add() {
        Store<User> store = new UserStore();
        User user1 = new User("1");
        User user2 = new User("2");
        store.add(user1);
        store.add(user2);
        assertThat(store.findById("1"), is(user1));
        assertThat(store.findById("2"), is(user2));
    }

    @Test
    public void replace() {
        Store<User> store = new UserStore();
        User user1 = new User("1");
        User user2 = new User("2");
        store.add(user1);
        store.add(user2);
        User user3 = new User("3");
        store.replace("2", user3);
        assertThat(store.findById("1"), is(user1));
        assertThat(store.findById("3"), is(user3));
        assertThat(store.findById("2"), is(nullValue()));
    }

    @Test
    public void delete() {
        Store<User> store = new UserStore();
        User user1 = new User("1");
        User user2 = new User("2");
        store.add(user1);
        store.add(user2);
        store.delete("2");
        User user3 = new User("2");
        store.add(user3);
        assertThat(store.findById("2"), is(user3));
    }

    @Test
    public void findById() {
        Store<User> store = new UserStore();
        User user1 = new User("1");
        User user2 = new User("2");
        store.add(user1);
        store.add(user2);
        assertThat(store.findById("3"), is(nullValue()));
    }
}
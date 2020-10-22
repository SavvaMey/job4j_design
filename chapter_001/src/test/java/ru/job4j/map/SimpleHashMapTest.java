package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    @Test
    public void getOne() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        Assert.assertEquals(map.get(2), "two");
    }

    @Test
    public void whenGrow() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.insert(3, "two");
        map.insert(4, "two");
        map.insert(5, "two");
        map.insert(6, "two");
        map.insert(7, "two");
        map.insert(8, "two");
        map.insert(9, "two");
        map.insert(10, "two");
        map.insert(11, "two");
        map.insert(12, "two");
        map.insert(13, "two");
        map.insert(14, "two");
        map.insert(15, "two");
        map.insert(16, "two");
        map.insert(17, "two");
        Assert.assertEquals(map.get(2), "two");
        Assert.assertEquals(map.get(17), "two");
    }

    @Test
    public void whenIdentic() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(1, "two");
        Assert.assertEquals(map.get(1), "two");
    }

    @Test
    public void insertOne() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        Assert.assertTrue(map.insert(1, "one"));
    }

    @Test
    public void deleteOne() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(2, "two");
        map.delete(2);
        Assert.assertNull(map.get(2));
        Assert.assertEquals(map.get(1), "one");
    }

    @Test
    public void iteratorHasNextTrue() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "one");
        Iterator<String> iterator = map.iterator();
        Assert.assertTrue(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorDeleteNext() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.delete(1);
        Iterator<String> iterator = map.iterator();
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNextNext() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "one");
        map.insert(2, "one");
        Iterator<String> iterator = map.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void iteratorNext() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "one");
        Iterator<String> iterator = map.iterator();
        assertThat(map.get(1), is(iterator.next()));
    }
}
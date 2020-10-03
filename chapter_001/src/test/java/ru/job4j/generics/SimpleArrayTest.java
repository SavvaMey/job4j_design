package ru.job4j.generics;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenEmptyEx() {
        SimpleArray<String> array = new SimpleArray<>(10);
        array.get(0);
    }

    @Test
    public void whenGeneraltest() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.remove(1);
        array.set(1, 10);
        array.add(100);
        assertThat(array.get(0), is(1));
        assertThat(array.get(1), is(10));
        assertThat(array.get(2), is(4));
        assertThat(array.get(3), is(100));
    }

    @Test
    public void whenGet() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        assertThat(array.get(0), is(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEx() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        assertThat(array.get(0), is(1));
        array.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddEx() {
        SimpleArray<Integer> array = new SimpleArray<>(1);
        array.add(1);
        assertThat(array.get(0), is(1));
        array.add(2);
    }

    @Test
    public void whenSet() {
        SimpleArray<Integer> array = new SimpleArray<>(1);
        array.add(1);
        assertThat(array.get(0), is(1));
        array.set(0, 2);
        assertThat(array.get(0), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenSetEx() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.set(1, 3);
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(1);
        assertThat(array.get(0), is(1));
        assertThat(array.get(1), is(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenRemoveEx() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.remove(1);
    }

    @Test
    public void hasNextFalse() {
        SimpleArray<Integer> integers = new SimpleArray<>(3);
        integers.add(1);
        Iterator<Integer> iterator = integers.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));

    }

    @Test(expected = NoSuchElementException.class)
    public void whenOutOfItThenEx() {
        SimpleArray<Integer> integers = new SimpleArray<Integer>(3);
        integers.add(0);
        Iterator<Integer> iterator = integers.iterator();
        iterator.next();
        iterator.next();
    }
}
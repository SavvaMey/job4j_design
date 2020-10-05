package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleListTest  {

    @Test
    public void whenAddThenGetSuccess() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(3));
        assertThat(list.get(3), is(4));
        assertThat(list.get(4), is(5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBounds() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(3);
    }

    @Test
    public void whenTestIterator() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterList = list.iterator();
        assertThat(iterList.next(), is(1));
        assertThat(iterList.next(), is(2));
        assertThat(iterList.next(), is(3));
        assertThat(iterList.next(), is(4));
        assertThat(iterList.next(), is(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenTestIteratorExcep() {
        SimpleList<Integer> list = new SimpleList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> iterList = list.iterator();
        assertThat(iterList.next(), is(1));
        assertThat(iterList.next(), is(2));
        assertThat(iterList.next(), is(3));
        assertThat(iterList.next(), is(4));
        assertThat(iterList.next(), is(5));
        assertThat(iterList.hasNext(), is(false));
        iterList.next();
    }
}
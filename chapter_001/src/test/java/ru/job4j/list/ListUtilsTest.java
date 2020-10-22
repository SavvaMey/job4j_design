package ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListUtilsTest {
    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 1, 2);
        assertThat(Arrays.asList(1, 3, 2), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 110, 100, 2));
        ListUtils.removeIf(input, integer -> integer > 90);
        assertThat(Arrays.asList(1, 2), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 110, 100, 2));
        ListUtils.replaceIf(input, integer -> integer > 90, 0);
        assertThat(Arrays.asList(1, 0, 0, 2), Is.is(input));
    }

    @Test
    public void whenRemoveAllfromElemenets() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 110, 100, 2));
        ListUtils.removeAll(input, Arrays.asList(1, 2));
        assertThat(Arrays.asList(110, 100), Is.is(input));
    }
}
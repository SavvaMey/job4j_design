package KissDryYagni;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    private List<Integer> list =Arrays.asList(10, 15, 100, -5, 10 , 2, 100, 3);
    private MaxMin maxMin = new MaxMin();
    private Comparator<Integer> comparator = Integer::compare;

    @Test
    public void max() {
        assertThat(maxMin.max(list, comparator), is(100));
    }

    @Test
    public void min() {
        assertThat(maxMin.min(list, comparator), is(-5));
    }
}
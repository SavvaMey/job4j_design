package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public EvenIt(int[] data) {
        this.data = data;
        this.point = 0;
    }

    @Override
    public boolean hasNext() {
        while (point < data.length) {
            if (data[point] % 2 == 0) {
                return true;
            }
            point++;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}

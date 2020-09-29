package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if ((data[row].length == 0) || (column == data[row].length)) {
            return (row + 1) < data.length;
        }
        return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        if (column == data[row].length) {
            column = 0;
            row++;
            while (data[row].length == 0) {
                row++;
                column = 0;
            }
            return data[row][column++];
        }
        return data[row][column++];
    }
}

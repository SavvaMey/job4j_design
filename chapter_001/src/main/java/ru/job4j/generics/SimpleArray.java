package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private T[] simpleArray;
    private int index = 0;

    public SimpleArray(int size) {
        this.simpleArray = (T[]) new Object[size];
    }

    public void add(T model) {
        Objects.checkIndex(index, simpleArray.length);
        simpleArray[index++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, this.index);
        simpleArray[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, this.index);
        this.index--;
        System.arraycopy(simpleArray, index + 1, simpleArray,
                index, this.index - index);
        simpleArray[this.index] = null;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return simpleArray[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return simpleArray[cursor++];
            }
        };
    }
}

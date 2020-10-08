package ru.job4j.list;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> array = new SimpleArray<T>(10);

    public void add(T element) {
            if (!array.checkUnique(element)) {
                array.add(element);
            }
    }

    @Override
    public Iterator<T> iterator() {
        return array.iterator();
    }
}

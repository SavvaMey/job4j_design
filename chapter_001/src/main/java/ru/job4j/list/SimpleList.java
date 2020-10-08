package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleList<E>  implements Iterable<E> {
    private SimpleLink<E> first;
    private SimpleLink<E> last;
    private int size = 0;
    private int modCount = 0;

    public SimpleList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public E add(E element) {
        SimpleLink<E> link = new SimpleLink<>(element);

        if (isEmpty()) {
            first = link;
            last = link;
        } else {
            last.next = link;
            last = link;
        }
        size++;
        modCount++;
        return last.data;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        SimpleLink<E> link = first;
        for (int i = 0; i < index; i++) {
             link = link.next;
        }
        return link.getData();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private SimpleLink<E> link = first;
            private SimpleLink<E> temp;
            private final int expectedModCount = modCount;
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                    temp = link;
                    link = link.next;
                    cursor++;
                    return temp.getData();
            }
        };
    }

    private static class SimpleLink<E> {
        private SimpleLink<E> next;
        private E data;

        public SimpleLink(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        @Override
        public String toString() {
            return "SimpleLink{"
                    + "data=" + data
                    + '}';
        }
    }
}

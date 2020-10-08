package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
        private Node<T> head;

        public void add(T value) {
            Node<T> node = new Node<T>(value, null);
            if (head == null) {
                head = node;
                return;
            }
            Node<T> tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }

    public void addFirst(T value) {
//        Node<T> node = new Node<T>(value, null);
//        if (head == null) {
//            head = node;
//            return;
//        }
//        node.next = head.next;
//        head = node;
        Node<T> old = head;
        head = new Node<>(value, null);
        head.next = old;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T PopValue = head.getValue();
        head = head.next;
        return PopValue;
    }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private Node<T> node = head;

                @Override
                public boolean hasNext() {
                    return node != null;
                }

                @Override
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    T value = node.value;
                    node = node.next;
                    return value;
                }
            };
        }

        private static class Node<T> {
            private T value;
            private Node<T> next;

            public Node(T value, Node<T> next) {
                this.value = value;
                this.next = next;
            }

            public T getValue() {
                return value;
            }
        }
}
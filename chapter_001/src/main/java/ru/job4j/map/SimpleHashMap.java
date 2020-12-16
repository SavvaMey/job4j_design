package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private int size = 16;
    private int countElements = 0;
    private int modCount = 0;
    private final double loadFactor = 0.75;
    private Node<K, V>[] container;

    public SimpleHashMap() {
        this.container = new Node[size];
    }

    boolean insert(K key, V value) {
        if ((size * loadFactor) == countElements) {
            growSize();
        }
        int ind = hash(key);
        if (container[ind] != null) {
            if (container[ind].getKey().equals(key)) {
                container[ind].setValue(value);
                return true;
            }
            return false;
        }
        Node<K, V> newNode = new Node<>(key, value);
        container[ind] = newNode;
        countElements++;
        modCount++;
        return true;
    }

    private void growSize() {
        size *= 2;
        Node<K, V>[] oldContainer = container;
        container = new Node[size];
        for (Node node: oldContainer) {
            if (node != null) {
                container[hash((K) node.getKey())] = node;
            }
        }

    }

    public V get(K key) {
        int ind = hash(key);
        if (container[ind] == null) {
            return null;
        } else if (container[ind].getKey().equals(key)) {
            return container[ind].getValue();
        }
        return null;
    }

    private int hash(K key) {
        return key.hashCode() % size;
    }

    boolean delete(K key) {
        int ind = hash(key);
        if (container[ind].getKey().equals(key)) {
            container[ind] = null;
            countElements--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private final int expectedModCount = modCount;
            private int cursor = 0;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count != countElements;
            }

            @Override
            public V next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Массив увеличен");
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
                for (int i = cursor; i < container.length; i++) {
                    if (container[i] != null) {
                        cursor = i;
                    }
                }
                count++;
                return container[cursor].getValue();
            }
        };
    }

    private static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

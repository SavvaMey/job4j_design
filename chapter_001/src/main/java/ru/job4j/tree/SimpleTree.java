package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface SimpleTree<E> {
    boolean add(E parent, E child);

    Optional<Node<E>> checkTree(Predicate<Node<E>> predicate);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public List<Node<E>> getChildren() {
            return children;
        }
    }
}

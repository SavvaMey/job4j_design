package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> parentNode = findBy(parent);
        if (!parentNode.isPresent()) {
            return false;
        }
        Optional<Node<E>> childNode = findBy(child);
        if (childNode.isEmpty()) {
            parentNode.get().children.add(new Node<>(child));
            return true;
        }
        return false;
    }

    public boolean isBinary() {
        Optional<Node<E>> rsl = checkTree(el -> el.children.size() > 2);
        return rsl.isEmpty();
    }

    public Optional<Node<E>> findBy(E value) {
        return checkTree(el -> el.getValue().equals(value));
    }

    @Override
    public Optional<Node<E>> checkTree(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}

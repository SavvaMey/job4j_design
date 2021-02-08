package isp;

import antlr.StringUtils;

import java.util.*;
import java.util.function.Predicate;

public class SimpleMenu implements AbstractMenu, PrintNode, AbstractAction {
    private final Node root;
    final String PRINT_FORMAT = "----";

    public SimpleMenu(final Node root) {
        this.root = root;
    }

    @Override
    public boolean add(String parent, String child) {
        Optional<Node> parentNode = findBy(parent);
        if (!parentNode.isPresent()) {
            return false;
        }
        Optional<Node> childNode = findBy(child);
        if (childNode.isEmpty()) {
            parentNode.get().children.add(new Node(child));
            return true;
        }
        return false;
    }

    @Override
    public Optional<Node> findBy(String value) {
        Optional<Node> rsl = Optional.empty();
        Queue<Node> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }


    @Override
    public void print(Node node, int level) {
        List<Node> list = node.getChildren();
        StringBuilder strPrint = new StringBuilder();
        strPrint.append(PRINT_FORMAT.repeat(Math.max(0, level - 1)));
        System.out.println(strPrint.toString() + node.getValue());
            for (Node nodeItem : list) {
                    print(nodeItem, level+ 1);
            }
    }

    @Override
    public void execute(String chose) {
        Optional<Node> node = findBy(chose);
        if (node.isPresent()) {
            System.out.println(node.get().getValue() + "выполнен");
        } else {
            System.out.println("такого пункта нет");
        }
    }

    static class Node {
        final String value;
        final List<Node> children = new ArrayList<>();

        public Node(String value) {
            this.value = value;
        }

        public List<Node> getChildren() {
            return children;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Node node = new Node("Задача 0.");
        SimpleMenu menu = new SimpleMenu(node);
        menu.add("Задача 0.", "Задача 1.");
        menu.add("Задача 1.", "Задача 1.1.");
        menu.add("Задача 1.", "Задача 1.2.");
        menu.add("Задача 1.1.", "Задача 1.1.1.");
        menu.add("Задача 1.1.", "Задача 1.1.2.");
        menu.add("Задача 1.2.", "Задача 1.2.1.");
        menu.add("Задача 0.", "Задача 2.");
        menu.print(node,0);
        menu.execute("Задача 3.");
        menu.execute("Задача 1.");
    }
}

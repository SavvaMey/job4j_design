package gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class CashOnSoftReference {
    private Map<String, SoftReference<String>> cash = new HashMap<>();

    public String get(String name) {
        cash.putIfAbsent(name, loadText(name));
            return cash.get(name).get();
    }

    private SoftReference<String> loadText(String name) {
        StringBuilder s = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                new FileReader("./chapter_004/src/filesForCash/" + name))) {
            in.lines().forEach(s::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new SoftReference<>(String.valueOf(s));
    }

    public static void main(String[] args) {
        CashOnSoftReference cash = new CashOnSoftReference();
        cash.get("Names.txt");
        System.out.println(cash.get("Names.txt"));
        cash.get("spam.txt");
        System.out.println(cash.get("spam.txt"));
        System.out.println(cash.get("towns.txt"));
    }
}

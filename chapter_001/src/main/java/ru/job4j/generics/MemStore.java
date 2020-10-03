package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int ind = mem.indexOf(findById(id));
        if (ind != -1) {
            mem.set(ind, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int ind = mem.indexOf(findById(id));
        if (ind != -1) {
            mem.remove(ind);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (T t : mem) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }
}

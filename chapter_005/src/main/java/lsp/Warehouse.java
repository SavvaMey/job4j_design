package lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return percentageSpent(food) < 0.25;
    }

    @Override
    public List<Food> clear() {
        List<Food> storeReturn = new ArrayList<>(store);
        store.clear();
        return storeReturn;
    }

    public List<Food> getStore() {
        return store;
    }
}

package lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean accept(Food food) {
        return  percentageSpent(food) >= 1;
    }

    @Override
    public List<Food> clear() {
        List<Food> storeReturn = store;
        store.clear();
        return storeReturn;
    }

    public List<Food> getStore() {
        return store;
    }
}

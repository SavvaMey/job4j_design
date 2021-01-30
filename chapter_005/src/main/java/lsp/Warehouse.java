package lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements StrategyStore {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean control(Food food) {
        return percentageSpent(food) < 0.25;
    }

    public List<Food> getStore() {
        return store;
    }
}

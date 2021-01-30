package lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements StrategyStore {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean control(Food food) {
        return  percentageSpent(food) >= 1;
    }

    public List<Food> getStore() {
        return store;
    }
}

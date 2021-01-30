package lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements StrategyStore {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean control(Food food) {
        double check = percentageSpent(food);
        if (check >= 0.25 && check < 1) {
            if (check > 0.75) {
                MakeDiscount disc = new MakeDiscount();
                disc.makeDiscount(food);
            }
            return true;
        }
        return false;
    }

    public List<Food> getStore() {
        return store;
    }
}

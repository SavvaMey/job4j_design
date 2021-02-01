package lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private List<Food> store = new ArrayList<>();

    @Override
    public void add(Food food) {
        store.add(food);
    }

    @Override
    public boolean accept(Food food) {
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

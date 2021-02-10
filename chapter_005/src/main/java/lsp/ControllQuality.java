package lsp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ControllQuality {
    private final List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
       this.storages = storages;
    }

    public void distribute(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                storage.add(food);
            }
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Storage storage : storages) {
            foods.addAll(storage.clear());
        }
        foods.forEach(this::distribute);
    }
}

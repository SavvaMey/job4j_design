package lsp;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
//    private  Warehouse warehouse;
//    private Trash trash;
//    private Shop shop;
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
}

package lsp;

public class ControllQuality {

    private  Warehouse warehouse;
    private Trash trash;
    private Shop shop;

    public ControllQuality(Warehouse warehouse, Trash trash, Shop shop) {
       this.warehouse = warehouse;
       this.trash = trash;
       this.shop = shop;
    }

    public void executeStrategy(Food food) {
         if (trash.control(food)) {
           trash.add(food);
       } else if (shop.control(food)) {
           shop.add(food);
       } else if (warehouse.control(food)) {
            warehouse.add(food);
        }
    }
}

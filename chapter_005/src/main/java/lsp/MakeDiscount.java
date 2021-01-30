package lsp;

public class MakeDiscount {
    private static final int DISCOUNT = 25;

    public void makeDiscount(Food food) {
        food.setDiscount(DISCOUNT);
        makeNewPrice(food);
    }

    private void makeNewPrice(Food food) {
        food.setPrice(food.getPrice() * (100 - DISCOUNT) / 100);
    }
}

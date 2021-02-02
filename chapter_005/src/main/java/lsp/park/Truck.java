package lsp.park;

public class Truck implements AbstractCar{
    private int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return 0;
    }
}

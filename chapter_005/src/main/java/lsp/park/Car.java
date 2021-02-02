package lsp.park;

public class Car implements AbstractCar{
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public int getSize() {
        return 1;
    }

    public String getName() {
        return name;
    }
}

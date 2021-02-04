package lsp.park;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

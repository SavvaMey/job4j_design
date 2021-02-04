package lsp.park;

import java.util.Objects;

public class Truck implements AbstractCar{
    private int size;
    private String name;

    public Truck(String name, int size) {
        this.size = size;
        this.name = name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return size == truck.size && Objects.equals(name, truck.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, name);
    }
}

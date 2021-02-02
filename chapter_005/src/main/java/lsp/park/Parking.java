package lsp.park;

import java.util.ArrayList;

public class Parking implements StrategyParking {
    private ArrayList<Truck> parkTruck;
    private ArrayList<Car> parkCar;
    private int cellsTruck;
    private int cellsCar;

    public Parking(int cellsTruck, int cellsCar) {
        this.cellsTruck = cellsTruck;
        this.cellsCar = cellsCar;
        this.parkTruck = new ArrayList<>(cellsTruck);
        this.parkCar = new ArrayList<>(cellsCar);
    }

    @Override
    public boolean parking(AbstractCar car) {
        return false;
    }

    public ArrayList<Truck> getParkTruck() {
        return parkTruck;
    }

    public ArrayList<Car> getParkCar() {
        return parkCar;
    }
}

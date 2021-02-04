package lsp.park;

import java.util.ArrayList;

public class Parking implements StrategyParking {
    private ArrayList<AbstractCar> parkTruck;
    private ArrayList<AbstractCar> parkCar;
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
        if (parkTruck.contains(car) || parkCar.contains(car)) {
            throw new IllegalArgumentException("такой машины уже есть");
        }
        if (car.getSize() != 1) {
            if (this.parkTruck.size() != this.cellsTruck) {
                this.parkTruck.add(car);
                return true;
            } else if (this.cellsCar - this.parkCar.size() >= car.getSize()) {
                for (int i = 0; i < car.getSize(); i++) {
                    parkCar.add(car);
                }
                return true;
            } else {
                return false;
            }
        } else if (this.parkCar.size() != this.cellsCar) {
            parkCar.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void remove(AbstractCar car) {
        int size = car.getSize();
        if (this.parkCar.contains(car)) {
            if (size == 1) {
                this.parkCar.remove(car);
            } else {
                this.parkCar.removeIf(p -> p.equals(car));
            }
        } else if (this.parkTruck.contains(car)) {
            this.parkTruck.remove(car);
        } else {
           throw new IllegalArgumentException("такой машины нет");
        }
    }

    public ArrayList<AbstractCar> getParkTruck() {
        return this.parkTruck;
    }

    public ArrayList<AbstractCar> getParkCar() {
        return this.parkCar;
    }
}

package lsp.park;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {

    @Test
    public void whenCarParkingThenTrue () {
        Car car = new Car("Nissan 1");
        Parking park = new Parking(10,10);
        assertThat(park.parking(car), is(true));
    }

    @Test
    public void whenCarParkingThenFalse () {
        Car car = new Car("Nissan 1");
        Car carAnother = new Car("Nissan 2");
        Parking park = new Parking(10,1);
        park.parking(carAnother);
        assertThat(park.parking(car), is(false));
    }

    @Test
    public void whenTruckParkingThenTrue () {
        Truck truck = new Truck("KAMAZ 1", 5);
        Parking park = new Parking(10,1);
        assertThat(park.parking(truck), is(true));
    }

    @Test
    public void whenTrackParkingThenFalse () {
        Truck truck = new Truck("KAMAZ 1", 5);
        Car car = new Car("Nissan 1");
        Parking park = new Parking(0,1);
        park.parking(car);
        assertThat(park.parking(truck), is(false));
    }

    @Test
    public void whenTrackParkingThenTrueInCarParking () {
        // парковка грузовика в парковку с легковыми
        Truck truck = new Truck("KAMAZ 1",5);
        Truck truckTwo = new Truck("KAMAZ 2",5);
        Car car = new Car("Nissan 1");
        Parking park = new Parking(1,10);
        park.parking(car);
        park.parking(truck);
        assertThat(park.parking(truckTwo), is(true));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenCarParkingThenThrow () {
        Car car = new Car("Nissan 1");
        Parking park = new Parking(1,10);
        park.parking(car);
        park.parking(car);
    }

    @Test
    public void whenCarRemove () {
        Car car = new Car("Nissan 1");
        Parking park = new Parking(1,10);
        park.parking(car);
        park.remove(car);
        assertThat(park.parking(car), is(true));
    }

    @Test
    public void whenTruckRemoveFromParkTruck () {
        Truck truck = new Truck("KAMAZ 1", 5);
        Parking park = new Parking(1,1);
        park.parking(truck);
        park.remove(truck);
        assertThat(park.parking(truck), is(true));
    }

    @Test
    public void whenTruckRemoveFromParkCar () {
        Truck truck = new Truck("KAMAZ 1", 5);
        Parking park = new Parking(0,5);
        park.parking(truck);
        park.remove(truck);
        assertThat(park.parking(truck), is(true));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenTruckRemoveThenThrow () {
        Truck truck = new Truck("KAMAZ 1", 5);
        Truck truckTwo = new Truck("KAMAZ 2", 5);
        Parking park = new Parking(0,5);
        park.parking(truck);
        park.remove(truckTwo);
    }
}
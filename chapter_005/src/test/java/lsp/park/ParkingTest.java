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
    public void whenTrackParkingThenTrue () {
        Truck truck = new Truck(5);
        Parking park = new Parking(10,1);
        assertThat(park.parking(truck), is(true));
    }

    @Test
    public void whenTrackParkingThenFalse () {
        Truck truck = new Truck(5);
        Car car = new Car("Nissan 1");
        Parking park = new Parking(1,1);
        park.parking(car);
        assertThat(park.parking(truck), is(false));
    }

    @Test
    public void whenTrackParkingThenTrueInCarParking () {
        // парковка грузовика в парковку с легковыми
        Truck truck = new Truck(5);
        Car car = new Car("Nissan 1");
        Parking park = new Parking(1,10);
        park.parking(car);
        assertThat(park.parking(truck), is(true));
    }
}
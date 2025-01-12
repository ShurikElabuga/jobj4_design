package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class ParkingTest {

    @Test
    void whenParkingCarAndTruck() {
        Vehicle car = new Car();
        Vehicle truck = new Truck(3);
        Park parking = new Parking(1, 1);
        assertTrue(parking.parking(car));
        assertTrue(parking.parking(truck));
    }

    @Test
    void whenParkingCarAndNotParkingTruck() {
        Vehicle car = new Car();
        Vehicle truck = new Truck(3);
        Park parking = new Parking(1, 0);
        assertTrue(parking.parking(car));
        assertFalse(parking.parking(truck));
    }

    @Test
    void whenParkingTruckAndNotParkingCar() {
        Vehicle car = new Car();
        Vehicle truck = new Truck(3);
        Park parking = new Parking(0, 1);
        assertFalse(parking.parking(car));
        assertTrue(parking.parking(truck));
    }

    @Test
    void whenParkHasPlacesForCarsButTrackParkingThere() {
        Vehicle car = new Car();
        Vehicle truck = new Truck(3);
        Park parking = new Parking(4, 0);
        assertTrue(parking.parking(car));
        assertTrue(parking.parking(truck));
    }

    @Test
    void whenParkHasNotPlaces() {
        Vehicle car = new Car();
        Vehicle truck = new Truck(3);
        Park parking = new Parking(0, 0);
        assertFalse(parking.parking(car));
        assertFalse(parking.parking(truck));
    }
}
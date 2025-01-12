package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Park {

    private int placeCar;
    private int placeTruck;
    private List<Vehicle> listVehicles = new ArrayList<>();

    public Parking(int placeCar, int placeTruck) {
        this.placeCar = placeCar;
        this.placeTruck = placeTruck;
    }

    @Override
    public boolean parking(Vehicle vehicle) {
        boolean result = false;
        int size = vehicle.getSize();
        if (size == 1 && placeCar > 0) {
            listVehicles.add(vehicle);
            placeCar--;
            result = true;
        }
        if (size > 1 && placeTruck > 0) {
            listVehicles.add(vehicle);
            placeTruck--;
            result = true;
        }
        if (size > 1 && size <= placeCar) {
            listVehicles.add(vehicle);
            placeCar--;
            result = true;
        }
        return result;
    }
}

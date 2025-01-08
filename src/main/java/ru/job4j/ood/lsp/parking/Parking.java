package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking implements Park {

    private int placeCar;
    private int placeTruck;
    private List<Vehicle> vehicles = new ArrayList<>();

    public Parking(int placeCar, int placeTruck) {
        this.placeCar = placeCar;
        this.placeTruck = placeTruck;
    }

    @Override
    public boolean parking(Vehicle vehicle) {
        return false;
    }
}

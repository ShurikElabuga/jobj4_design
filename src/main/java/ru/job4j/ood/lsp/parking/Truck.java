package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {

    private int truckSize;

    public Truck(int truckSize) {
        this.truckSize = truckSize;
    }

    @Override
    public int getSize() {
        return truckSize;
    }
}

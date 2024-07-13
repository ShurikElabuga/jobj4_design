package ru.job4j.serialization.json;

import java.util.Arrays;

public class Flight {
    private final boolean isReady;
    private final int fuelling;
    private final String airline;
    private final Aircraft aircraftType;
    private final String[] models;

    public Flight(boolean isReady, int fuelling, String airline, Aircraft aircraftType, String[] models) {
        this.isReady = isReady;
        this.fuelling = fuelling;
        this.airline = airline;
        this.aircraftType = aircraftType;
        this.models = models;
    }

    @Override
    public String toString() {
        return "ru.job4j.serialization.json.Flight{"
                + "isReady=" + isReady
                + ", fuelling=" + fuelling
                + ", airline='" + airline + '\''
                + ", aircraftType=" + aircraftType
                + ", models=" + Arrays.toString(models)
                + '}';
    }
}

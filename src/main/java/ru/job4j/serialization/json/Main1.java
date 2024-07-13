package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main1 {
    public static void main(String[] args) {
        Flight flight = new Flight(true, 58000, "Aeroflot", new Aircraft("Boeing"),
                new String[] {"737", "747", "777"});

        final Gson gson = new GsonBuilder().create();
        final String flightJson = gson.toJson(flight);
        System.out.println(flightJson);

        System.out.println(gson.fromJson(flightJson, Flight.class));
    }
}

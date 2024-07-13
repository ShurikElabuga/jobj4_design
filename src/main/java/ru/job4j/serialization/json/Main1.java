package ru.job4j.serialization.json;


import org.json.JSONObject;

public class Main1 {
    public static void main(String[] args) {
        Flight flight = new Flight(true, 58000, "Aeroflot", new Aircraft("Boeing"),
                "737", "747", "777");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ready", flight.isReady());
        jsonObject.put("fuelling", flight.getFuelling());
        jsonObject.put("airline", flight.getAirline());
        jsonObject.put("aircraft", flight.getAircraftType());
        jsonObject.put("models", flight.getModels());

        System.out.println(jsonObject);
        System.out.println(new JSONObject(flight));

    }
}

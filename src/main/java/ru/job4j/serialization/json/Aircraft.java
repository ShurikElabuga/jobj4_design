package ru.job4j.serialization.json;

public class Aircraft {
    private final String type;

    public Aircraft(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Aircraft{"
                + "type='" + type + '\''
                + '}';
    }
}

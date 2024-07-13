package ru.job4j.serialization.json;

public class Contact {
    private final String phone;

    public Contact(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ru.job4j.serialization.json.Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}

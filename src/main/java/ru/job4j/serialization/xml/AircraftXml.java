package ru.job4j.serialization.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "aircraft")
public class AircraftXml {

    @XmlAttribute
    private String type;

    public AircraftXml() {}

    public AircraftXml(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Aircraft{"
                + "type='" + type + '\''
                + '}';
    }
}

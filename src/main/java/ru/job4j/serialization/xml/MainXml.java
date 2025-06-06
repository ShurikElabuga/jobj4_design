package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;

public class MainXml {
    public static void main(String[] args) throws Exception {
        final FlightXml flight = new FlightXml(true, 58000, "Aeroflot",
                new AircraftXml("Boeing"), "737", "747", "777");
        /* Получаем контекст для доступа к АПИ */
        JAXBContext context = JAXBContext.newInstance(FlightXml.class);
        /* Создаем сериализатор */
        Marshaller marshaller = context.createMarshaller();
        /* Указываем, что нам нужно форматирование */
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml;
        try (StringWriter writer = new StringWriter()) {
            /* Сериализуем */
            marshaller.marshal(flight, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        /* Для десериализации нам нужно создать десериализатор */
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            /* десериализуем */
            FlightXml result = (FlightXml) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}

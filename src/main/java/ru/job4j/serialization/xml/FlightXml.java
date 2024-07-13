package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;


@XmlRootElement(name = "flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlightXml {
  @XmlAttribute
  private boolean isReady;
  @XmlAttribute
  private int fuelling;
  @XmlAttribute
  private String airline;
  private AircraftXml aircraftType;
  @XmlElementWrapper(name = "models")
  @XmlElement(name = "model")
  private String[] models;

  public FlightXml() {}

    public FlightXml(boolean isReady, int fuelling, String airline, AircraftXml aircraftType, String... models) {
        this.isReady = isReady;
        this.fuelling = fuelling;
        this.airline = airline;
        this.aircraftType = aircraftType;
        this.models = models;
    }

    @Override
    public String toString() {
        return "Flight{"
                + "isReady=" + isReady
                + ", fuelling=" + fuelling
                + ", airline='" + airline + '\''
                + ", aircraftType=" + aircraftType
                + ", models=" + Arrays.toString(models)
                + '}';
    }

    public static void main(String[] args) throws JAXBException{
        final FlightXml flight = new FlightXml(true, 58000, "Aeroflot",
                new AircraftXml("Boeing"), "737", "747", "777");

        JAXBContext context = JAXBContext.newInstance(FlightXml.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(flight, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

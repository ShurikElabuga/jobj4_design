package ru.job4j.ood.srp.report;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.WrapEmployee;
import ru.job4j.ood.srp.store.Store;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportXML implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportXML(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        Wrap wrap = new Wrap();
        for (Employee employee : store.findBy(filter)) {
            WrapEmployee wrapEmployee = new WrapEmployee(
                    employee.getName(),
                    dateTimeParser.parse(employee.getHired()),
                    dateTimeParser.parse(employee.getFired()),
                    employee.getSalary()
            );
            wrap.add(wrapEmployee);
        }
        try {
            JAXBContext context = JAXBContext.newInstance(Wrap.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(wrap, writer);
                xml = writer.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }

    @XmlRootElement(name = "wrap")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Wrap {
        @XmlElement(name = "wrapEmployee")
        private List<WrapEmployee> wrapEmployees = new ArrayList<>();

        public Wrap(List<WrapEmployee> wrapEmployees) {
            this.wrapEmployees = wrapEmployees;
        }

        public Wrap() {
        }

        public List<WrapEmployee> getWrapEmployees() {
            return wrapEmployees;
        }

        public void setWrapEmployees(List<WrapEmployee> wrapEmployees) {
            this.wrapEmployees = wrapEmployees;
        }

        public void add(WrapEmployee wrapEmployee) {
            wrapEmployees.add(wrapEmployee);
        }
    }
}

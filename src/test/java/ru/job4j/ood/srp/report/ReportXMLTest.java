package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class ReportXMLTest {

    @Test
    void whenGenerateXMLReport() {
        Store store = new MemoryStore();
        GregorianCalendar calendar =
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 42);
        Employee employee1 = new Employee("Boris", calendar, calendar, 100000);
        Employee employee2 = new Employee("Igor", calendar, calendar, 200000);
        store.add(employee1);
        store.add(employee2);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        ReportXML report = new ReportXML(store, parser);
        String result = report.generate(employee -> true);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<wrap>\n"
                + "    <wrapEmployee>\n"
                + "        <name>Boris</name>\n"
                + "        <hired>08:06:2023 17:42</hired>\n"
                + "        <fired>08:06:2023 17:42</fired>\n"
                + "        <salary>100000.0</salary>\n"
                + "    </wrapEmployee>\n"
                + "    <wrapEmployee>\n"
                + "        <name>Igor</name>\n"
                + "        <hired>08:06:2023 17:42</hired>\n"
                + "        <fired>08:06:2023 17:42</fired>\n"
                + "        <salary>200000.0</salary>\n"
                + "    </wrapEmployee>\n"
                + "</wrap>\n";
        assertThat(result).isEqualTo(expected);
    }
}
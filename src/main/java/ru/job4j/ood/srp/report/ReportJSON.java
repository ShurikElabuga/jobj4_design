package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.WrapEmployee;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportJSON(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
            Gson gson = new GsonBuilder().create();
            List<WrapEmployee> employees = new ArrayList<>();
            for (Employee employee : store.findBy(filter)) {
                WrapEmployee wrapEmployee = new WrapEmployee(
                        employee.getName(),
                        dateTimeParser.parse(employee.getHired()),
                        dateTimeParser.parse(employee.getFired()),
                        employee.getSalary()
                );
                employees.add(wrapEmployee);
            }
            return gson.toJson(employees);
        }
    }


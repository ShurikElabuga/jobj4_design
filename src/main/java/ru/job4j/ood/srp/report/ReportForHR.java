package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.sort.SortDescSalary;
import ru.job4j.ood.srp.store.Store;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHR implements Report {
    private final Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    private List<Employee> sortSalary(Predicate<Employee> filter) {
            List<Employee> result = store.findBy(filter);
        Collections.sort(result, new SortDescSalary());
            return result;

    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        List<Employee> list = sortSalary(filter);
        text.append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : list) {
            text.append(employee.getName()).append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

package ru.job4j.ood.srp.sort;

import ru.job4j.ood.srp.model.Employee;

import java.util.Comparator;

public class SortDescSalary implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o2.getSalary() - o1.getSalary());
    }
}

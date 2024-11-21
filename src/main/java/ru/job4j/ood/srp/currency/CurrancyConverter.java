package ru.job4j.ood.srp.currency;

public interface CurrancyConverter {
    double convert(Currency source, double sourceValue, Currency target);

}

package ru.job4j.ood.lsp.foodstorage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculationRemainingLife {

    public double calculate(Food food) {
        LocalDate create = food.getCreateDate();
        LocalDate expiry = food.getExpiryDate();
        double period = ChronoUnit.DAYS.between(create, expiry);
        double passed = ChronoUnit.DAYS.between(create, LocalDate.now());
        return passed / period * 100;
    }
}

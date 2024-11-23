package ru.job4j.ood.ocp.example;

public class TaxCalculate {
        public double calculateTax(double income) {
                return income * 0.2; /*метод возвращает сумму налога с дохода*/
            }
           /* Если появится еще какой-то источник дохода или надо расчитать новый тип налога,
             надо будет изменять метод calculateTax, что нарушает принцип OCP*/
        }


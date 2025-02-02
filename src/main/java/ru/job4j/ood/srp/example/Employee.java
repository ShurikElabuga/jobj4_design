package ru.job4j.ood.srp.example;

public class Employee {

    /* Класс одновременно отвечает за количество отработанных часов работником и за расчет его заработной платы,
    что нарушает принцип SRP*/

    public int calculatePay() {
        return 0;
        /*метод расчитывает зарплату работника*/
    }

    public int reportHours() {
        return 0;
        /*метод возвращает количество часов отработанных работником*/
    }
}

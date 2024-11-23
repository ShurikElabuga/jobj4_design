package ru.job4j.ood.srp;

public class Payment {

    /* Класс выполняет три функции: обработка платежа, отправку подтверждения платежа
    *   и создание отчета о платеже, что нарушает принцип SRP,
    * т.к. изменения в одной области могут повлечь изменения в другой */

    public void processPayment() {

        /* метод для обработки платежа */
    }

    public void sendConfirmation() {

        /* метод для отправки подтверждения платежа */
    }

    public void reportPayment() {

        /* метод для создания отчета о платеже */
    }
}
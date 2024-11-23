package ru.job4j.ood.ocp.example;

public class NotificationService {
    public void sendNotification(String type, String message) {
        /*Метод отправляет уведомление по электронной почте или с помощью смс*/
        if (type.equals("EMAIL")) {
            System.out.println("Sending email: " + message);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS: " + message);
        }
    }
    /*Добавление нового типа отправки уведомления требует изменения метода*/
}

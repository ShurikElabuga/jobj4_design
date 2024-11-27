package ru.job4j.ood.dip.example;

public class Heater {
    public void heat() {
        System.out.println("Heater is heating");
    }
}

class Room {
    private Heater heater; /*Жесткая зависимость*/

    public Room() {
        this.heater = new Heater();
    }

    public void warmUp() {
        heater.heat();  /*Класс Room зависит от конкретной реализации Heater*/
    }
}
    /*Класс Room создаёт экземпляр класса Heater, что делает его жёстко связанным с конкретной реализацией*/

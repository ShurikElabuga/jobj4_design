package ru.job4j.ood.dip.example;

public class LightBulb {

    public void turnOn() {
        System.out.println("Light Bulb turned on");
    }

    public void turnOff() {
        System.out.println("Light Bulb turned off");
    }
}

   class Switch {
    private LightBulb lightBulb; /*Конкретная зависимость от класса LightBulb*/

    public Switch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    public void operate() {
        lightBulb.turnOn();  /*Зависимость от конкретного класса*/
    }
}

   /* Класс Switch напрямую зависит от LightBulb, что увеличивает связанность и сложности в тестировании */

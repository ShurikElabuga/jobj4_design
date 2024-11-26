package ru.job4j.ood.isp.example;

public interface Vehicle {
    void drive();
    void refuel();
    void fly(); /*Летать могут не все транспортные средства*/
}

class Car implements Vehicle {
    @Override
    public void drive() {

    }
    @Override
    public void refuel() {

    }

    @Override
    public void fly() {  /*Метод fly() не применим для автомобиля*/
        throw new UnsupportedOperationException("Car can't fly!");
    }
}


class Plane implements Vehicle {
    public void drive() {
        /*это может быть не применимо или не нужно*/
    }

    public void refuel() {

    }

    public void fly() {

    }
}

/*Класс Car вынужден реализовывать метод fly(), который не соответствует его функциональности, следовательно, это нарушает принцип ISP.
* Необходимо для летательных аппаратов создать отдельный интерфейс*/

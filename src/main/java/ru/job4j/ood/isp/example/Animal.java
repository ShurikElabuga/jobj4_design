package ru.job4j.ood.isp.example;

public interface Animal {
    void eat();
    void sleep();
    void fly(); /*Этот метод может не подходить для всех животных*/
}

class Bird implements Animal {
    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }
    @Override
    public void fly() {

    }
}


class Cat implements Animal {

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void fly() {  /*Метод fly() не имеет смысла для кота*/
        throw new UnsupportedOperationException("Cat can't fly!");
    }
}

   /*Kласс Cat вынужден реализовывать метод fly(), который не имеет смысла для данного класса, что нарушает ISP.*/

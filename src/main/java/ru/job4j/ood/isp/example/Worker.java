package ru.job4j.ood.isp.example;

public interface Worker {
    void work();
    void takeBreak();
    void meeting(); /* Не все работники должны ходить на встречи */
}



class OfficeWorker implements Worker {

    @Override
    public void work() {

    }
    @Override
    public void takeBreak() {

    }

    @Override
    public void meeting() {

    }
}



class Freelancer implements Worker {

    @Override
    public void work() {

    }

    @Override
    public void takeBreak() {

    }

    @Override
    public void meeting() { /* Фрилансер не обязан посещать встречи*/
        throw new UnsupportedOperationException("Freelancer doesn’t attend meetings.");
    }
}

   /*Здесь интерфейс Worker требует от фрилансера реализации метода meeting(), который для него не актуален, что противоречит ISP.*/

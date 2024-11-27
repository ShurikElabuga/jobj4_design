package ru.job4j.ood.dip.example;

public class NetworkService {
    public void connect() {
        System.out.println("Connected to network");
    }
}

class Application {
    private NetworkService networkService; /*Прямое использование конкретного типа*/

    public Application() {
        this.networkService = new NetworkService(); /*Зависимость от конкретного класса*/
    }

    public void start() {
        networkService.connect();
    }
}

/*Класс Application создаёт прямую зависимость от класса NetworkService, что затрудняет замену компонента и тестирование*/


package ru.job4j.ood.lsp.foodStorage.store;

import ru.job4j.ood.lsp.foodStorage.Food;

import java.util.List;

public interface Store {

    void add(Food product);
    void move(Food product, double remainingLife);
    List<Food> getAll();

}

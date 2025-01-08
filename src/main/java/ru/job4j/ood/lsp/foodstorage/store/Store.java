package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.Food;

import java.util.List;

public interface Store {

    void add(Food product);
    void move(Food product, double remainingLife);
    List<Food> getAll();
    void delete();

}

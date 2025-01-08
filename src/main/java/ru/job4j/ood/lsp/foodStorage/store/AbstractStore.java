package ru.job4j.ood.lsp.foodStorage.store;

import ru.job4j.ood.lsp.foodStorage.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    public final static double TRASH = 100.0;
    public final static double SHOP_MIN = 25.0;
    public final static double SHOP_MAX = 75.0;
    public final static double DISCOUNT = 0.2;

    private List<Food> products = new ArrayList<>();

    @Override
    public void add(Food product) {
        products.add(product);
    }

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(products);
    }
}

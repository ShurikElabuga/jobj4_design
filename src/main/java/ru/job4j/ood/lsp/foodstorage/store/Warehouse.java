package ru.job4j.ood.lsp.foodstorage.store;

import ru.job4j.ood.lsp.foodstorage.Food;

public class Warehouse extends AbstractStore {

    @Override
    public void move(Food product, double remainingLife) {
        if (remainingLife < SHOP_MIN) {
            add(product);
        }
    }
}

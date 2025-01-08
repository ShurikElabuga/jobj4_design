package ru.job4j.ood.lsp.foodStorage.store;

import ru.job4j.ood.lsp.foodStorage.Food;

public class Shop extends AbstractStore {
    @Override
    public void move(Food product, double remainingLife) {
        if (remainingLife >= SHOP_MIN && remainingLife <= SHOP_MAX) {
            add(product);
        }
        if (remainingLife > SHOP_MAX && remainingLife < TRASH) {
            product.setDiscount(product.getPrice() - product.getPrice() * DISCOUNT);
            add(product);
        }
    }
}

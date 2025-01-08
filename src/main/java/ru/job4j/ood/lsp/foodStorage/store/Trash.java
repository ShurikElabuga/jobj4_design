package ru.job4j.ood.lsp.foodStorage.store;

import ru.job4j.ood.lsp.foodStorage.Food;

public class Trash extends AbstractStore {
    @Override
    public void move(Food product, double remainingLife) {
        if (remainingLife >= TRASH) {
            add(product);
        }
    }
}

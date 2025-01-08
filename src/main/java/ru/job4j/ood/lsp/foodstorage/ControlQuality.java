package ru.job4j.ood.lsp.foodstorage;

import ru.job4j.ood.lsp.foodstorage.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void destribution(Food product, CalculationRemainingLife calculator) {
        double remainingLife = calculator.calculate(product);
        for (Store s : stores) {
            s.move(product, remainingLife);
        }
    }

    public void resort() {
        List<Food> products = new ArrayList<>();
        for (Store store : stores) {
            products.addAll(store.getAll());
            store.delete();
        }
        for (Food prod : products) {
            destribution(prod, new CalculationRemainingLife());
        }
    }
}

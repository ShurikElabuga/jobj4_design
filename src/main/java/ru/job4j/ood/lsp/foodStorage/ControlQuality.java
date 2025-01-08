package ru.job4j.ood.lsp.foodStorage;

import ru.job4j.ood.lsp.foodStorage.store.Store;

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
}

package ru.job4j.ood.lsp.foodStorage;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodStorage.store.Shop;
import ru.job4j.ood.lsp.foodStorage.store.Store;
import ru.job4j.ood.lsp.foodStorage.store.Trash;
import ru.job4j.ood.lsp.foodStorage.store.Warehouse;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    @Test
    void whenProductMoveInShop() {
        List<Store> stores = List.of(new Trash(), new Warehouse(), new Shop());
        ControlQuality control = new ControlQuality(stores);
        Food product = new Food("Milk", LocalDate.of(2025, 01, 30), LocalDate.of(2024, 12, 30), 100.0);
        control.destribution(product, new CalculationRemainingLife());
        Food expectProduct = stores.get(2).getAll().get(0);
        assertThat(expectProduct).isEqualTo(product);
    }

    @Test
    void whenProductMoveInShopAndGetNewDiscount() {
        List<Store> stores = List.of(new Trash(), new Warehouse(), new Shop());
        ControlQuality control = new ControlQuality(stores);
        Food product = new Food("Milk", LocalDate.of(2025, 01, 10), LocalDate.of(2024, 12, 30), 100.0);
        control.destribution(product, new CalculationRemainingLife());
        Food expectProduct = stores.get(2).getAll().get(0);
        double expectDiscount = product.getPrice() - (product.getPrice() * 0.2);
        assertThat(product.getDiscount()).isEqualTo(expectDiscount);
        assertThat(expectProduct).isEqualTo(product);

    }
}
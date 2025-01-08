package ru.job4j.ood.lsp.foodStorage.store;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodStorage.Food;

import java.time.LocalDate;


class WarehouseTest {

    @Test
    void whenRemainingLife0ThenMove() {
        Food expected = new Food("Milk", LocalDate.now(), LocalDate.now(), 74.0);
        Store warehouse = new Warehouse();
        warehouse.move(expected, 0.0);
        Assertions.assertThat(warehouse.getAll().get(0).equals(expected));
    }

    @Test
    void whenRemainingLifeLessThan25ThenMove() {
        Food expected = new Food("Milk", LocalDate.now(), LocalDate.now(), 74.0);
        Store warehouse = new Warehouse();
        warehouse.move(expected, 24.0);
        Assertions.assertThat(warehouse.getAll().get(0).equals(expected));
    }
}
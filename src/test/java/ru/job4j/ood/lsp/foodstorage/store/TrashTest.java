package ru.job4j.ood.lsp.foodstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class TrashTest {

    @Test
    void whenRemainingLife100ThenMove() {
        Food expected = new Food("Milk", LocalDate.now(), LocalDate.now(), 74.0);
        Store trash = new Trash();
        trash.move(expected, 100.0);
        assertThat(trash.getAll().get(0)).isEqualTo(expected);
    }

    @Test
    void whenRemainingLife101ThenMove() {
        Food expected = new Food("Milk", LocalDate.now(), LocalDate.now(), 74.0);
        Store trash = new Trash();
        trash.move(expected, 101.0);
        assertThat(trash.getAll().get(0)).isEqualTo(expected);
    }
}
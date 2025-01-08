package ru.job4j.ood.lsp.foodstorage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.foodstorage.Food;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    @Test
    void whenRemainingLifeMore25ButLess75ThanMove() {
        Food expected = new Food("Milk", LocalDate.now(), LocalDate.now(), 74.0);
        Store shop = new Shop();
        shop.move(expected, 50.0);
        assertThat(shop.getAll().get(0)).isEqualTo(expected);
    }

    @Test
    void whenRemainingLifeMore75ButLess100ThanMove() {
        Food expected = new Food("Milk", LocalDate.now(), LocalDate.now(), 100.0);
        Store shop = new Shop();
        shop.move(expected, 99.0);
        assertThat(shop.getAll().get(0)).isEqualTo(expected);

    }

    @Test
    void whenRemainingLifeMore75ThanGetNewDiscount() {
        Food expected = new Food("Milk", LocalDate.now(), LocalDate.now(), 100.0);
        Store shop = new Shop();
        shop.move(expected, 99.0);
        Food product = shop.getAll().get(0);
        double expectDiscount = product.getPrice() - (product.getPrice() * AbstractStore.DISCOUNT);
        assertThat(product.getDiscount()).isEqualTo(expectDiscount);
    }
}
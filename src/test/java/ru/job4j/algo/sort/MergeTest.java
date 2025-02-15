package ru.job4j.algo.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeTest {

    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenLengthIsOne() {
        int[] array = {10};
        assertThat(Merge.mergesort(array)).containsExactly(10);
    }

    @Test
    void whenNumbersAreEqual() {
        int[] array = {5, 5, 5, 5, 5};
        assertThat(Merge.mergesort(array)).containsExactly(5, 5, 5, 5, 5);
    }

    @Test
    void whenSortIsOk() {
        int[] array = {9, 9, 9, -1, 3, 3, 3, 3, 2, 0};
        assertThat(Merge.mergesort(array)).containsExactly(-1, 0, 2, 3, 3, 3, 3, 9, 9, 9);
    }
}
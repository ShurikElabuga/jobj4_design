package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ListUtilsTest {
    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIf() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 8, 10, 12));
        Predicate<Integer> filter = x -> x > 5;
        ListUtils.removeIf(list, filter);
        assertThat(list).containsExactly(1, 3, 5);
    }

    @Test
    void whenReplaceIf() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 8, 10, 12));
        Predicate<Integer> filter = x -> x > 5;
        ListUtils.replaceIf(list, filter, 100);
        assertThat(list).containsExactly(1, 3, 5, 100, 100, 100);
    }

    @Test
    void whenRemoveAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 5, 8, 10, 12));
        List<Integer> listElements = new ArrayList<>(Arrays.asList(1, 5, 8, 12));
        ListUtils.removeAll(list, listElements);
        assertThat(list).containsExactly(3, 10);
    }

}
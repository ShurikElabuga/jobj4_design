package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import org.assertj.core.data.Index;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }
    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five", "ten", "one");
        assertThat(list)
                .hasSize(7)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1))
                .startsWith("first", "second")
                .endsWith("ten", "one")
                .containsSequence("three", "four")
                .filteredOn(e -> e.length() < 5)
                .anyMatch(e -> e.length() == 3)
                .element(1).isNotNull()
                .isEqualTo("five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five", "ten", "one");
        assertThat(set)
                .hasSize(7)
                .contains("second")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("two")
                .filteredOn(e -> e.length() < 5)
                .anySatisfy(e -> {
                    assertThat(e.length()).isEqualTo(3);
                    assertThat(e.length()).isGreaterThan(2);
                }).first().isEqualTo("four");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("nine", "two", "three", "four", "five", "ten", "one");
        assertThat(map)
                .hasSize(7)
                .containsKeys("two", "four")
                .containsValue(3)
                .doesNotContainKey("seven")
                .doesNotContainValue(8)
                .containsEntry("one", 6);

    }


}
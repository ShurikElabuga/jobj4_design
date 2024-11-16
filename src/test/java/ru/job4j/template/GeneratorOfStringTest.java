package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Disabled
class GeneratorOfStringTest {

    @Test
    void whenProduceCorrectString() {
        Generator generator = new GeneratorOfString();
        String template = "I am %S, Who are %S?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Boris");
        map.put("subject", "you");
        String expected = "I am Boris, Who are you?";
        String result = generator.produce(template, map);
        assertThat(expected).isEqualTo(result);
    }

    @Test
    void whenMapHasNotKeyThenGetException() {
        Generator generator = new GeneratorOfString();
        String template = "I am %s, Who are %s?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Boris");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenMapHasExcessKeyThenGetException() {
        Generator generator = new GeneratorOfString();
        String template = "I am %s, Who are %s?";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Boris");
        map.put("surname", "Borisov");
        map.put("subject", "you");
        assertThatThrownBy(() -> generator.produce(template, map))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
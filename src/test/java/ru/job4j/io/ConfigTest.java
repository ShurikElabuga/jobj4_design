package ru.job4j.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("cadet2")).isEqualTo("Guliev");
        assertThat(config.value("cadet3")).isEqualTo("Samsonov=");
    }

    @Test
    void whenPairWithoutCommentIsException() {
        String path = "./data/lines_contain_wrong_template.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("wrong template");
    }

    @Test
    void whenPairIsException() {
        String path = "./data/wron_template.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("wrong template");
    }

    @Test
    void whenFileHasException() {
        String path = "./data/pair_have_wrong_template.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("wrong template");
    }

    @Test
    void whenIsException() {
        String path = "./data/pair_wrong_template.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("wrong template");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pait_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("cadet4")).isEqualTo("Sidorov");
    }
}
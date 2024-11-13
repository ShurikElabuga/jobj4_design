package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void createAnswerWhen3() {
        assertThat(Fool.createAnswer(3)).isEqualTo("Fizz");
    }

    @Test
    void createAnswerWhen5() {
        assertThat(Fool.createAnswer(5)).isEqualTo("Buzz");
    }

    @Test
    void createAnswerWhen3and5() {
        assertThat(Fool.createAnswer(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void createAnswerWhen8() {
        assertThat(Fool.createAnswer(8)).isEqualTo(String.valueOf(8));
    }

    @Test
    void checkAnswerIsTrue() {
        assertThat(Fool.checkAnswer("12", 12)).isTrue();
    }

    @Test
    void checkAnswerIsFalse() {
        assertThat(Fool.checkAnswer("Fizz", 12)).isFalse();
    }
}
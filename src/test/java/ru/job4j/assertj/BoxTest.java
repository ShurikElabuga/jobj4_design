package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isUnknown() {
        Box box = new Box(1, 11);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isUnknownToo() {
        Box box = new Box(4, 0);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object");
    }

    @Test
    void isThisVertex() {
        Box box = new Box(4, 4);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(4);
    }

    @Test
    void vertexIsNegative() {
        Box box = new Box(4, 0);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void isExistTrue() {
        Box box = new Box(8, 8);
        assertThat(box.isExist()).isTrue();
    }

    @Test
    void isExistFalse() {
        Box box = new Box(0, 0);
        assertThat(box.isExist()).isFalse();
    }

    @Test
    void areaSphere() {
        Box box = new Box(0, 4);
        double value = box.getArea();
        double scale = Math.pow(10, 2);
        double result = Math.ceil(value * scale) / scale;
        assertThat(result).isEqualTo(201.07d, withPrecision(0.007d))
                .isCloseTo(201.06d, withPrecision(0.01d))
                .isCloseTo(201.06d, Percentage.withPercentage(1.0d))
                .isGreaterThan(201.06d)
                .isLessThan(201.08d);
    }

    @Test
    void areaIsZero() {
        Box box = new Box(3, 9);
        assertThat(box.getArea()).isEqualTo(0.0d);
    }
}
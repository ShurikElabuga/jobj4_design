package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    private int sizeIn;
    private int sizeOut;

    public T poll() {
        if (sizeIn == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        T result = input.pop();
        sizeIn--;
        return result;
    }

    public void push(T value) {
        if (sizeIn == 0) {
            input.push(value);
            sizeIn++;
        } else {
            for (int i = 0; i < sizeIn; i++) {
                output.push(input.pop());
                sizeOut++;
                sizeIn--;
            }
            input.push(value);
            sizeIn++;
            for (int j = 0; j < sizeOut; j++) {
                input.push(output.pop());
                sizeIn++;
                sizeOut--;
            }
        }
    }
}

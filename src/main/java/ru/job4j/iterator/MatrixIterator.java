package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int column;

    public MatrixIterator(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
       while (row < data.length) {
           if (column < data[row].length) {
               result = true;
               break;
           }
           row++;
           column = 0;
       }
       return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return column < data[row].length ? data[row][column++] : data[row++][0];
    }
}

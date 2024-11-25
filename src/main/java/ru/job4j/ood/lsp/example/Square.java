package ru.job4j.ood.lsp.example;

public class Square extends Rectangle {
    /*Класс неправильно определен как наследник класса Rectangle,
    * потомучто высоту и ширину прямоугольника можно изменять независимо,
    * а высоту и ширину квадрата можно изменять только вместе*/
    private int side;

    public Square(int side) {
        super(side, side);
    }
}

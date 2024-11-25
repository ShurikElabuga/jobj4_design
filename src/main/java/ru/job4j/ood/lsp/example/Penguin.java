package ru.job4j.ood.lsp.example;

public class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Пингвины не летают");
    }
    /*Причина нарушения принципа LSP в том, что "Пингвин" является подклассом "Птицы", но не может выполнять метод "fly",
       что нарушает ожидания пользователей базового класса.*/
}

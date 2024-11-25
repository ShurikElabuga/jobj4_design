package ru.job4j.ood.lsp.example;

public class Cardiologist extends Doctor {
    @Override
    public void treat() {
        System.out.println("Я лечу сердце");
    }
}

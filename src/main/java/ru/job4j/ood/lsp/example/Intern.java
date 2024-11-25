package ru.job4j.ood.lsp.example;

public class Intern extends Doctor {
    @Override
    public void treat() {
        throw new UnsupportedOperationException("Стажеры не лечат людей");
    }
    /*Причина нарушения принципа lsp: "Стажер" как подкласс "Доктора" не может выполнять метод "treat",
      что делает иерархию некорректной с точки зрения подстановки.*/
}

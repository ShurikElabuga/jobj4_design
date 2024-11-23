package ru.job4j.ood.ocp.example;

public class FilesHandler {

    public void handleFile(String fileType) {
        /*Метод обрабатывает два типа файлов*/
        if (fileType.equals("PDF")) {
            System.out.println("Handling PDF file");
        } else if (fileType.equals("DOC")) {
            System.out.println("Handling DOC file");
        }
    }
    /*Если потребуется добавить новый тип файла, то необходимо изменить этот метод,
    * что нарушает принцип OCP*/
}

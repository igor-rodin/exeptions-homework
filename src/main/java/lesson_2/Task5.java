package lesson_2;

/*
 * Придумайте структуру класса, на ваш выбор. Создайте json массив с 4-5 объектами этого класса.
 * Загрузите файл .json на ваш гитхаб. Напишите программу, которая скачивает файл, маппит его в Java объекты,
 * с помощью jacksonmapper и выводит массив в консоль.
 * В build.gradle в разделе dependic.. указать implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0"), чтобы сказать гредл
 */

import lesson_2.services.DownloadService;
import lesson_2.services.FileService;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Task5 {

    private static final String FILE_URI = "https://raw.githubusercontent.com/igor-rodin/exeptions-homework/lesson_2/Books.json";

    public static void main(String[] args) {
        DownloadService downloadService = new DownloadService();

        Path fileName;
        try {
            fileName = downloadService.downloadFile(FILE_URI);
            System.out.println(fileName);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ошибка при скачивании", e);
        }

        FileService fileService = new FileService();
        List<Book> books;
        try {
            books = fileService.readJsonFileAsList(fileName);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении JSON файла", e);
        }

        System.out.println(books);
    }
}

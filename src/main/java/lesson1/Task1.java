package lesson1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения


public class Task1 {
    public static void main(String[] args) throws IOException {

        int[] numbers = {1, 3};
        System.out.println(calcAverage(numbers, 0, 3));

        getNameAndAge();

        System.out.println(readTextFile("test.txt"));
    }


    /*
     *   Будут получены исключения:
     *     - ArrayIndexOutOfBoundsException, если задать некорректные minIndexInclusive и maxIndexExcluding
     *     - NullPointerException, если передать null вместо numbers
     */
    public static double calcAverage(int[] numbers, int minIndexInclusive, int maxIndexExcluding) {
        int sum = 0;

        for (int i = minIndexInclusive; i < maxIndexExcluding; i++) {
            sum += numbers[i];
        }

        return (double) sum / numbers.length;
    }


    /*
     *  Будет получено исключение InputMismatchException в 35 строке,
     *  если вместо целого числа ввести что-нибудь другое.
     */
    public static void getNameAndAge() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        scanner.close();
        System.out.println(String.format("Welcome, %s. You are %d age years.", name, age));
    }


    /*
     * Будут получены исключения:
     *     - NoSuchFileException, если файл с именем fileName не существует
     *     - IOException
     *     - OutOfMemoryError, если размер файла очень большой
     */
    public static String readTextFile(String fileName) throws IOException {
        return Files.readString(Path.of(fileName));
    }
}

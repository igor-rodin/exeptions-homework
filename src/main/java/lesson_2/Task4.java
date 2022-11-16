package lesson_2;
/*
 *  Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 *  Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        String message = getMessage();
        System.out.println("Ваше сообщение: " + message);
    }

    public static String getMessage() {
        while (true) {
            System.out.println("Введите сообщение: ");
            String input = new Scanner(System.in).nextLine();
            if (input.isBlank()) {
                System.out.println("Пустые строки вводить нельзя");
                throw new RuntimeException("Пустые строки вводить нельзя");
            }
            return input;
        }
    }
}

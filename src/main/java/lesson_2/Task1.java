package lesson_2;

/*
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        float number = getInput();
        System.out.println("Вы ввели: " + number);
    }

    public static float getInput() {
        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                return Float.valueOf(new Scanner(System.in).next());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        }
    }
}
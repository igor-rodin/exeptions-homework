package lesson_2;

/*
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        float number = getInput();
//        float number = getInputWithTryCatch();
        System.out.println("Вы ввели: " + number);
    }

    /*
     * Вариант без генерации исключений
     */
    public static float getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        String value = scanner.nextLine();

        while (!isRational(value)) {
            System.out.println("Неверный ввод -> " + value);
            System.out.print("Введите дробное число: ");
            value = scanner.nextLine();
        }
        return Float.valueOf(value);
    }

    /*
     * Вариант с генерацией исключения
     */
    public static float getInputWithTryCatch() {
        while (true) {
            try {
                System.out.print("Введите дробное число: ");
                return Float.valueOf(new Scanner(System.in).next());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        }
    }


    public static boolean isRational(String value) {
        boolean canBeRational = true;
        int dotCounts = 0;
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i)) && value.charAt(i) != '.') {
                canBeRational = false;
            }
            if (value.charAt(i) == '.') {
                dotCounts++;
                if (dotCounts > 1) {
                    canBeRational = false;
                    break;
                }
            }
        }
        return canBeRational;
    }
}
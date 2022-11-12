package lesson1;

/*
 *   Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 *   каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
 *   Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] firstArr = {1, 3, 9, -2};
        int[] secondArr = {-2, 9, 16};

        System.out.println(Arrays.toString(calcDifOf(firstArr, secondArr)));
    }

    public static int[] calcDifOf(int[] first, int[] second) {
        if (first.length != second.length) {
            throw new RuntimeException("Массивы должны быть одного размера");
        }

        int[] result = new int[first.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = first[i] - second[i];
        }
        return result;
    }
}

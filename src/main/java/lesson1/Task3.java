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

    public static int[] calcDifOf(int[] firstArray, int[] secondArray) {
        if (firstArray.length != secondArray.length) {
            throw new RuntimeException("Массивы должны быть одного размера");
        }

        int[] result = new int[firstArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = firstArray[i] - secondArray[i];
        }
        return result;
    }
}

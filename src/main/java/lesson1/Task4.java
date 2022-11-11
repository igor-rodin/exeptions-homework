package lesson1;

/*
 *  Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 *  каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
 *  Если длины массивов не равны, необходимо как-то оповестить пользователя.
 *  Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] firstArr = {1, 3, 9, -2};
        int[] secondArr = {-2, 9, 16};

        System.out.println(Arrays.toString(calcQuotientOf(firstArr, secondArr)));
    }

    public static double[] calcQuotientOf(int[] firstArray, int[] secondArray) {
        if (firstArray.length != secondArray.length) {
            throw new RuntimeException("Массивы должны быть одного размера");
        }

        double[] result = new double[firstArray.length];
        for (int i = 0; i < result.length; i++) {
            if (secondArray[i] == 0) {
                String errorMessage = String.format("На ноль делить нельзя. Индекс нулевого элемента - %d", i);
                throw new RuntimeException(errorMessage);
            }

            result[i] = (double) firstArray[i] / secondArray[i];
        }
        return result;
    }
}

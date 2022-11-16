package lesson_2;

/*
 *  Дан следующий код, исправьте его там, где требуется
 *  (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 *  версия без try catch, с обработкой if
 */

public class Task3v2 {
    public static void main(String[] args) {

        int a = 90;
        int b = 3;
        if (b == 0) {
            throw new RuntimeException("На ноль делить нельзя");
        }
        System.out.println(a / b);

        printSum(23, 234);

        int[] abc = {1, 2};
        int index = 3;
        if (index < 0 || index >= abc.length) {
            throw new RuntimeException("Массив выходит за пределы своего размера!");
        }
        abc[index] = 9;
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}

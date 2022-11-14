package lesson_2;

/*
 *  Если необходимо, исправьте данный код (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 */

public class Task2 {

    private static final int CATCHED_INDEX = 8;

    public static void main(String[] args) {

    }

    public static void divideBy(int d, int[] intArray) {
        if (d == 0) {
            throw new RuntimeException("На ноль делить нельзя");
        }

        if (CATCHED_INDEX >= intArray.length || CATCHED_INDEX < 0) {
            throw new RuntimeException("Индекс выходит за границы массива");
        }

        double catchedRes = intArray[CATCHED_INDEX] / d;
        System.out.println("catchedRes = " + catchedRes);
    }
}

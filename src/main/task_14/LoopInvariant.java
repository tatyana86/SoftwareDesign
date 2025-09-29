package main.task_14;

public class LoopInvariant {

    public static int findMax(int[] arr) {

        if (arr.length <= 0) {
            throw new IllegalArgumentException("List should not be empty.");
        }

        int max = arr[0];

        for (int n : arr) {
            // если очередной элемент больше max,
            // то он становится новым max
            // -> на каждом цикле max - максимальное из всех проверенных элементов
            if (n > max) {
                max = n;
            }
            // иначе в max также максимальный элемент
        }

        return max;

    }

}

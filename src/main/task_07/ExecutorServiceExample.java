package main.task_07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        int[] numbers = {1, 2, 3, 4, 5};

        Future<Integer>[] futures = new Future[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            futures[i] = executor.submit(() -> num * num);
        }

        int sum = 0;
        for (Future<Integer> f : futures) {
            sum += f.get();
        }

        System.out.println("Сумма квадратов: " + sum);

        executor.shutdown();
    }
}
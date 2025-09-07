package main.task_07;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " пытается получить разрешение...");
                semaphore.acquire(); // захватываем разрешение
                System.out.println(Thread.currentThread().getName() + " получил разрешение, работает...");
                Thread.sleep(1000); // имитация работы
                System.out.println(Thread.currentThread().getName() + " освобождает разрешение");
                semaphore.release(); // освобождаем разрешение
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task, "Поток-" + i).start();
        }
    }
}
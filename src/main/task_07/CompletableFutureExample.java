package main.task_07;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // три задачи, имитирующих загрузку с разных серверов
        CompletableFuture<String> server1 = loadFromServer("Server1", 1500);
        CompletableFuture<String> server2 = loadFromServer("Server2", 1000);
        CompletableFuture<String> server3 = loadFromServer("Server3", 2000);

        // объединяем все три CompletableFuture в один, который завершится, когда все три будут готовы
        CompletableFuture<Void> allOf = CompletableFuture.allOf(server1, server2, server3);

        // объединяем результаты после завершения всех задач
        CompletableFuture<String> combinedResult = allOf.thenApply(v -> {
            try {
                String result1 = server1.get();
                String result2 = server2.get();
                String result3 = server3.get();
                return result1 + " | " + result2 + " | " + result3;
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        combinedResult.thenAccept(result -> System.out.println("Объединенный результат: " + result));
        try {
            combinedResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    // метод, имитирующий загрузку данных с сервера с задержкой
    private static CompletableFuture<String> loadFromServer(String serverName, int delayMillis) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Загрузка с " + serverName + " с задержкой " + delayMillis);
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return serverName;
        });
    }
}
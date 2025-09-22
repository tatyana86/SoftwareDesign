package main.task_12;

import java.io.IOException;

public class ProtectionExample {


    public static void main(String[] args) {
        try {
            Config config = new Config("config.properties");
            String plannerType = config.getRoutePlannerType();

            RoutePlanner routePlanner;
            if ("optimized".equalsIgnoreCase(plannerType)) {
                routePlanner = new OptimizedRoutePlanner();
            } else {
                routePlanner = new SimpleRoutePlanner();
            }

            OrderProcessor processor = new OrderProcessor(routePlanner);

            Order order1 = new Order("ORD001", "Москва");
            Order order2 = new Order("ORD002", "Казань");
            processor.processOrder(order1);
            processor.processOrder(order2);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении конфигурации: " + e.getMessage());
        }
    }


}

package main.task_12;

public class OrderProcessor {

    private final RoutePlanner routePlanner;

    public OrderProcessor(RoutePlanner routePlanner) {
        this.routePlanner = routePlanner;
    }

    public void processOrder(Order order) {
        System.out.println("Обработка заказа: " + order.getOrderId());
        routePlanner.planRoute(order);
    }

}

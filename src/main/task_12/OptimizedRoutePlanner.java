package main.task_12;

public class OptimizedRoutePlanner implements RoutePlanner {

    @Override
    public void planRoute(Order order) {
        System.out.println("Планируем оптимизированный маршрут для заказа: " + order.getOrderId());
    }

}

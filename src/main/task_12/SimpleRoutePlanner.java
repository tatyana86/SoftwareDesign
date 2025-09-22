package main.task_12;

public class SimpleRoutePlanner implements RoutePlanner {

    @Override
    public void planRoute(Order order) {
        System.out.println("Планируем простой маршрут для заказа: " + order.getOrderId());
    }

}

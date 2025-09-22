package main.task_12;

public class Order {

    private final String orderId;
    private final String destination;

    public Order(String orderId, String destination) {
        this.orderId = orderId;
        this.destination = destination;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDestination() {
        return destination;
    }

}

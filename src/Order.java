import java.util.ArrayList;
import java.util.List;

class Order {
    private static int orderCounter = 1;
    private static int orderDetailCounter = 1;
    private int orderID;
    private int userID;
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Order(int userID) {
        this.orderID = orderCounter++;
        this.userID = userID;
    }

    public int getOrderID() { return orderID; }

    public void addOrderDetail(Product product, int quantity) {
        try {
            OrderDetail detail = new OrderDetail(orderDetailCounter++, product, quantity);
            orderDetails.add(detail);
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }

    public double calculateTotal() {
        return orderDetails.stream().mapToDouble(OrderDetail::getSubTotal).sum();
    }

    @Override
    public String toString() {
        return "Order #" + orderID + " (User ID: " + userID + ")\nItems:\n" + orderDetails;
    }
}
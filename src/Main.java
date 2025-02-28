import java.util.*;

public class Main {
    private static List<Order> orders = new ArrayList<>();
    private static HashMap<Integer, List<Order>> userOrderHistory = new HashMap<>();
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        products.add(new Electronics(1, "Laptop", 1000, 5, 2));
        products.add(new Electronics(2, "Smartphone", 800, 10, 1));
        products.add(new Clothing(3, "T-Shirt", 20, 50, "M"));
        products.add(new Clothing(4, "Jeans", 40, 30, "L"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Place Order\n2. View Order History\n3. Exit");
            int choice = scanner.nextInt();
            if (choice == 3) break;
            switch (choice) {
                case 1 -> placeOrder(scanner);
                case 2 -> viewOrderHistory(scanner);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        Order order = new Order(userID);

        while (true) {
            System.out.println("\nAvailable Products:");
            products.forEach(p -> System.out.println(p.productID + ". " + p));
            System.out.print("Enter Product ID (0 to finish): ");
            int productID = scanner.nextInt();
            if (productID == 0) break;
            Product selectedProduct = products.stream().filter(p -> p.getProductID() == productID).findFirst().orElse(null);
            if (selectedProduct == null) {
                System.out.println("Invalid product!");
                continue;
            }
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            order.addOrderDetail(selectedProduct, quantity);
        }
        orders.add(order);
        userOrderHistory.putIfAbsent(userID, new ArrayList<>());
        userOrderHistory.get(userID).add(order);
        System.out.println("Order placed! Total: $" + order.calculateTotal());
    }

    private static void viewOrderHistory(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userID = scanner.nextInt();
        List<Order> userOrders = userOrderHistory.get(userID);
        if (userOrders == null || userOrders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            userOrders.forEach(System.out::println);
        }
    }
}

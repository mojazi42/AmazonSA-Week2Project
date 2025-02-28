abstract class Product {
    protected int productID;
    protected String name;
    protected String category;
    protected double price;
    protected int stockQuantity;

    public Product(int productID, String name, String category, double price, int stockQuantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getProductID() { return productID; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public void reduceStock(int quantity) { this.stockQuantity -= quantity; }
    public abstract double calculateDiscount();
}
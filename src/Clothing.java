class Clothing extends Product {
    private String size;

    public Clothing(int productID, String name, double price, int stockQuantity, String size) {
        super(productID, name, "Clothing", price, stockQuantity);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.15;
    }
}

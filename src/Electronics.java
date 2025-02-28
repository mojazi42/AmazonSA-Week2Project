class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(int productID, String name, double price, int stockQuantity, int warrantyPeriod) {
        super(productID, name, "Electronics", price, stockQuantity);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateDiscount() {
        return price * 0.10;
    }
}
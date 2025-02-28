class OrderDetail {
    private int orderDetailID;
    private Product product;
    private int quantity;
    private double subTotal;

    public OrderDetail(int orderDetailID, Product product, int quantity) throws OutOfStockException {
        if (product.getStockQuantity() < quantity) {
            throw new OutOfStockException("Product " + product.getName() + " is out of stock!");
        }
        this.orderDetailID = orderDetailID;
        this.product = product;
        this.quantity = quantity;
        this.subTotal = quantity * (product.getPrice() - product.calculateDiscount());
        product.reduceStock(quantity);
    }

    public double getSubTotal() { return subTotal; }

    @Override
    public String toString() {
        return product.getName() + " x " + quantity + " = $" + subTotal;
    }
}

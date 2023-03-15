public class Product {
    private String productID;
    private String name;
    private double price;
    private boolean status;

    public Product(String productID, String name, double price, boolean status) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.productID + "," + this.name + "," + this.price + "," + this.status;
    }
}

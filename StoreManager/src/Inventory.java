import java.util.Date;

public class Inventory {
    private String productName;
    private Date date;
    private String quantity;

    public Inventory(String productName,String quantity, Date date) {
        this.quantity = quantity;
        this.productName = productName;
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public  String toString(){
        return this.productName + "," + quantity + "," + date;
    }
}

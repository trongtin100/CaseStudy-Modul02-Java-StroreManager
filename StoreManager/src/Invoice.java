import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Invoice{
    private String invoiceID;

    private String customerID;
    private Date date;
    private HashMap<String, Integer> products;

    public Invoice(String invoiceID, String customerID, Date date, HashMap<String, Integer> products) {
        this.invoiceID = invoiceID;
        this.date = date;
        this.customerID = customerID;
        this.products = products;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public HashMap<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, Integer> products) {
        this.products = products;
    }

    public double getSubTotal(String productID, int quatity){
        // tim dc product thong qua product id;
        ProductManager productManager = new ProductManager();
        Product p = productManager.searchById(productID);
        double price = p.getPrice();
        return price * quatity ;
    }

    public double getTotal() {
        // lay duoc ds sp kh dang mua(HashMap product)
        double total = 0.0;
        for (String productID : products.keySet()){
            int quantyti = products.get(productID);
            total += getSubTotal(productID, quantyti);
        }
        return total;
    }

    public String getCustomerName() {
        CustomerManagement customerManagament = new CustomerManagement();
        Customer c = customerManagament.searchById(customerID);
        if(this.customerID.equals(c.getCusID())) {
            String customerName = c.getName();
            return customerName;
        }
        return null;
    }
    public String toString2(){
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yy-hh:mm:ss");
        String info = this.invoiceID + "," + this.customerID + "," + simpleFormat.format(this.date);
        for(String productID : products.keySet()){
            info += "," + productID + "," + products.get(productID);
        }
        return info;

    }

    @Override
    public String toString() {
       ProductManager productManager = new ProductManager();
        String sout = "";
        // print first part:

        sout = "Invoice Number: " + this.invoiceID + "\n"
                + "Customer ID: " + getCustomerName() + "\n"
                + "Date: " + this.date + "\n";
        sout += "======================"+"\n";
        //print second part:
        for (String productID : products.keySet()){
            Product p = productManager.searchById(productID);
            int quantyti = products.get(productID);
            sout += p.getName() + " - " + p.getPrice() + "$ - SL: " +
                    products.get(productID) + " - "
                    + getSubTotal(productID, quantyti) + "$ " + "\n";
        }
        sout += "======================"+"\n";
        //print part 3:
        double total = getTotal() - (getTotal() * 10 / 100);
        double discount = getTotal() - (getTotal() * 5 / 100);
        if(getTotal() >= 500){
            return sout += "Total: " + total + "$\n\n";
        }else if(getTotal() >= 250) {
            return sout += "Total: " + discount + "$\n\n";
        }else {
            return sout += "Total: " + getTotal() + "$\n\n";
        }
    }
}

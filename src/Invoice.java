import java.util.HashMap;
import java.util.Date;

public class Invoice {
    private String invoiceID;
    private String customerID;
    private TableType tableType;
    private Date invoiceDate;
    HashMap< String , Integer > foods;
   
    public Invoice(String invoiceID, String customerID,TableType tableType, Date invoiceDate) {
        this.invoiceID = invoiceID;
        this.customerID = customerID;
        this.invoiceDate = invoiceDate;
        this.foods = new HashMap<>();
    }

    public void addFodd(String foodID, Integer quantity){
        this.foods.put(foodID,quantity);
    }

    public String getInvoiceID() {return invoiceID;}
    public void setInvoiceID(String invoiceID) {this.invoiceID = invoiceID;}
    
    public Date getInvoiceDate() {return invoiceDate;}
    public void setInvoiceDate(Date invoiceDate) {this.invoiceDate = invoiceDate;}
    
    public HashMap<String, Integer> getFoods() { return foods;}
    public void setFoods(HashMap<String, Integer> foods) {this.foods = foods;}

    public String getCustomerID() {return customerID;}
    public void setCustomerID(String customerID) {this.customerID = customerID;}

    //Calculate subTotal bill.
    public double getSubTotal(String foodID,Integer quantity){
        FoodManagement foodManagement = new FoodManagement();
        Food f = foodManagement.searchByID(foodID);
        double sum = 0;
        sum += f.getFoodPrice() * quantity; 
        return sum;
    }
    //Get surcharge by TypeTable
    //Get CustomerName
    public Customer getCustomerName(){
        CustomerManagement customerManagement = new CustomerManagement();
        Customer getCustomer = customerManagement.searchByID(customerID);
        return getCustomer;
    }

    
    //Calculate Total bill = subtotal + subtotal.....
    public double getTotal(){
        double total = 0;
        for(String foodID : foods.keySet()){
            int quantity = foods.get(foodID);
            total += getSubTotal(foodID, quantity);
        }

        return total*SurchargeTable.getSurchargeTable(this.tableType) * SurchargeTable.discountBill(total);
    }
    
    public String toString(){
        
        String printBill = "=============================================" +"\n";
        printBill += "InvoiceID: " + getInvoiceID() + "\n"
                    + "Customer Name: " + getCustomerName() + "\n"
                    + "TypeTable: " + "add code" + "\n"
                    + "InvoiceDate: " + new Date() + "\n";
            
        printBill += "=============================================" + "\n";
        for(String foodID : foods.keySet()){
            FoodManagement foodManagement = new FoodManagement();
            Food f = foodManagement.searchByID(foodID);
            int quantity = foods.get(foodID);
        printBill += "FoodName: " + f.getFoodName()
                    + "  FoodPrice: " + f.getFoodPrice()
                    + "  Quantity: " + quantity
                    + "  SubTotal: " + getSubTotal(foodID, quantity) +"\n";
        }
        printBill += "=============================================" + "\n";
                    if(getTotal() > SurchargeTable.Discount){
                        printBill += "Discount: 10%" + "\n";
                    }else{
                        printBill += "";
                    }
        printBill += "Total: "+ getTotal() ;
        return printBill;
    }
}

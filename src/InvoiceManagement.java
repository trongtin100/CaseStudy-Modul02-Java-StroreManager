
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class InvoiceManagement implements ManagerAble {
    Scanner scanner = new Scanner(System.in);
    List<Invoice> invoices;
    
    
    public InvoiceManagement(){
        invoices = new ArrayList<>();
    }
 
    //Search bill by InvoiceID
    public Invoice searchByInvoiceID(String searchID){
        for(Invoice i : invoices){
            if(i.getInvoiceID().equals(searchID)){
                return i;
            }
        }
        return null;
    }
    public Invoice input(){
        System.out.println("Enter invoiceID: ");
        String invoiceID = scanner.next();
        System.out.println("Enter customerID: ");
        String customerID = scanner.next();
       
        System.out.println("Enter typeTable: ");
        String typeTable = scanner.next();

       
        Invoice i = new Invoice(invoiceID, customerID,(typeTable.equals("1")?TableType.VIP:TableType.Normal), new Date());
        while(true){
            System.out.println("Enter foodName: ");
            String foodID = scanner.next();
            if(foodID.equals("")) break;
            System.out.println("Enter foodQuantity: ");
            Integer quantity = scanner.nextInt();
            i.addFodd(foodID, quantity);
        }
        
        return i;
    }

    @Override
    public void add() {
       Invoice newInvoice = input();
       invoices.add(newInvoice);
       System.out.println(newInvoice.toString());
    }

    @Override
    public void search() {
        System.out.println("Enter invoiceID: ");
        String searchID = scanner.next();

        Invoice i = searchByInvoiceID(searchID);
        System.out.println(i);
    }

    @Override
    public void update() {
        
        
    }

    @Override
    public void remove() {
       
        
    }
    
}   

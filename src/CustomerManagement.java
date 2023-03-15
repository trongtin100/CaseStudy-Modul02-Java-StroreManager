import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement implements ManagerAble {
    Scanner scanner = new Scanner(System.in);
    List < Customer > customers;

    public CustomerManagement(){
        customers = new ArrayList<>();

        Customer customerOne = new Customer("Tin2k", "Tin", "TP.HCM", "0909.09.08.07");
        Customer customerTwo = new Customer("An98", "An", "TP.HCM", "0909.07.08.09");
        customers.add(customerOne);
        customers.add(customerTwo);
    }

    //Add Customer 
    public Customer input(){    
        System.out.print("Add customerID: ");
        String customerID = scanner.next();
        System.out.print("Add customerName: ");
        scanner.nextLine();
        String customerName = scanner.next();
        System.out.print("Add customerAddress: ");
        String customerAddress = scanner.next();
        System.out.print("Add customerPhone: ");
        String customerPhone = scanner.next();

        Customer addCustomer = new Customer(customerID, customerName, customerAddress, customerPhone);
        return addCustomer;
    }

    // Search Customer By ID.
    public Customer searchByID(String searchID){
        for(Customer c : customers){
            if(c.getCustomerID().equals(searchID)) return c;
        }
        return null;
    }

    //Add customer by input()
    @Override
    public void add() {
        Customer newCustomer = input();
        customers.add(newCustomer);
    }

    //Search customer by searchByID()
    @Override
    public void search() {
        System.out.print("Enter customerID to search: ");
        String searchID = scanner.next();

        Customer searchCustomer = searchByID(searchID);
        System.out.println(searchCustomer.toString());
    }

    // Update Information by searchByID
    @Override
    public void update() {
        System.out.print("Enter customerID to update: ");
        String searchID = scanner.next();
        System.out.println("----------Enter new information -----------");
        System.out.print("Enter customerID:  ");
        String customerID = scanner.next();
        System.out.print("Enter customerName: ");
        scanner.nextLine();
        String customerName = scanner.next();
        System.out.print("Enter customerAddress:  ");
        String customerAddress = scanner.next();
        System.out.print("Enter customerPhone: ");
        String customerPhone = scanner.next();

        Customer updateCustomer = searchByID(searchID);
        updateCustomer.setCustomerID(customerID);
        updateCustomer.setCustomerName(customerName);
        updateCustomer.setCustomerAddress(customerAddress);
        updateCustomer.setCustomerPhone(customerPhone);
    }

    @Override
    public void remove() {
        System.out.println("Enter customerID to remove");
        String searchID = scanner.next();

        Customer removeCustomer = searchByID(searchID);
        customers.add(removeCustomer);
        
    }
}

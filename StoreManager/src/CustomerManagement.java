import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement extends Menu implements learnAble{
    List<Customer> customers;
    Scanner sc= new Scanner(System.in);
    public CustomerManagement(){
        customers = new ArrayList<>();
        readToFile();
    }

    @Override
    public void add() {
        try {
            Customer newCustomer = input();
            customers.add(newCustomer);
            saveToFile();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void saveToFile() {
        try {
            FileWriter file = new FileWriter("customer.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(file);
            for (Customer c : customers) {
                bufferedWriter.write(c.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readToFile(){
        customers.clear();
        try {
            FileReader fileReader = new FileReader("customer.txt");
            Scanner sc = new Scanner(fileReader);
            String line = "";
            while (sc.hasNextLine()){
                line = sc.nextLine();
                Customer newC = xuLyLine(line);
                if(newC != null){
                    customers.add(newC);
                }
            }
            fileReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Customer xuLyLine(String line) {
        try {
            String[] ss = line.split(",");
            Customer newCustomer = new Customer(ss[0],ss[1],ss[2],ss[3]);
            return newCustomer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Customer input() {
        System.out.println("Enter cusId");
        String id = sc.nextLine();
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter phone");
        String phone = sc.nextLine();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        Customer newCustomer = new Customer(id, name, phone, address);
        return newCustomer;
    }

    @Override
    public void update() {
        System.out.println("Enter search Id");
        String fix = sc.next();
        for (Customer c : customers){
            if(c.getCusID().equals(fix)){
                System.out.println("Enter address edit");
                String fixAddress = sc.nextLine();
                c.setAddress(fixAddress);
                System.out.println(c);
            }
        }
        saveToFile();
    }

    @Override
    public void remove() {
        System.out.println("Enter search Id");
        String remove = sc.next();
        for (Customer c : customers){
            if(c.getCusID().equals(remove)){
                customers.remove(c);
                break;
            }
        }
        saveToFile();
    }

    @Override
    public void search() {
        System.out.println("Enter search Id");
        String search = sc.next();
        Customer customerSearch = searchById(search);
        if(customerSearch != null){
            System.out.println(customerSearch);
        }
    }

    public Customer searchById(String search){
        for (Customer c : customers) {
            if(c.getCusID().equals(search)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}

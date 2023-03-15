import java.io.*;
import java.util.*;

public class InvoiceManager implements learnAble{
    List<Invoice> invoices;
    Scanner sc = new Scanner(System.in);
    public InvoiceManager(){
        invoices = new ArrayList<>();
        readAllFromFile();
    }
    @Override
    public void add() {
        try {
            Invoice newInvoice = input();
            invoices.add(newInvoice);
            saveAllToFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void saveAllToFile() {
        try {
            FileWriter newFile = new FileWriter("invoice.txt", false);
           // BufferedWriter bufferedWriter = new BufferedWriter(newFile);
            PrintWriter printer = new PrintWriter(newFile);
            for(Invoice i : invoices){
               /* bufferedWriter.write(i.toString());
                bufferedWriter.newLine();
*/
               printer.println(i.toString2());
            }

            newFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readAllFromFile() {
        invoices.clear();
        try {
            FileReader newFile = new FileReader("invoice.txt");
            Scanner scanner = new Scanner(newFile);
            String line="";
            while(scanner.hasNextLine()){
                 line = scanner.nextLine();
                 //xu ly linef
                Invoice newInvoice = xuLyInvoiceLine(line);
                if (newInvoice != null)
                    invoices.add(newInvoice);

            }
            newFile.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Invoice xuLyInvoiceLine(String line) {
        try {
            String[] ss = line.split(",");
            Invoice newInvoice = new Invoice(ss[0], ss[1], new Date(ss[2]), null);
            //tao HashMap
            HashMap<String, Integer> buyingProducts = new HashMap<>();
            for (int i = 3; i < ss.length - 1; i += 2) {
                buyingProducts.put(ss[i], Integer.parseInt(ss[i + 1]));
            }
            newInvoice.setProducts(buyingProducts);
            return newInvoice;
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Loi line!");
            return null;
        }
    }

    private Invoice input() {
        HashMap<String, Integer> products = new HashMap<>();
        System.out.print("Enter invoiceID: ");
        String invoiceID = sc.nextLine();
        System.out.print("Enter customerID: ");
        String customerID = sc.nextLine();
        String productID;

        do {
            System.out.print("Enter productID: ");
            productID = sc.nextLine();
            if(productID.equals("")) {break;}
            System.out.print("Enter quantyti: ");
            Integer quantyti = Integer.parseInt(sc.nextLine());
            products.put(productID, quantyti);
        } while (!productID.equals(""));

        Invoice newInvoice = new Invoice(invoiceID, customerID, new Date(), products);
        return newInvoice;
    }

    @Override
    public void update() {
        System.out.print("Enter Invoice id: ");
        String search = sc.nextLine();
        Invoice updateInvoiceId = searchInvoiceId(search);
        if(updateInvoiceId != null){
            System.out.print("Enter Invoice id edit: ");
            String update = sc.nextLine();

            updateInvoiceId.setInvoiceID(update);
            saveAllToFile();

            System.out.println(updateInvoiceId);
        }
    }
    @Override
    public void remove() {
        System.out.print("Enter Invoice id: ");
        String search = sc.nextLine();
        Invoice removeInvoiceId = searchInvoiceId(search);
        if(removeInvoiceId != null){
            invoices.remove(removeInvoiceId);
        }
        saveAllToFile();
    }

    @Override
    public void search() {
        System.out.print("Enter search Invoice ID: ");
        String search = sc.nextLine();
        Invoice searchId =  searchInvoiceId(search);
        if(searchId != null ){
            System.out.println(searchId);
        }
    }

    public Invoice searchInvoiceId(String search) {
        for (Invoice i : invoices){
            if(i.getInvoiceID().equals(search)){
                return i;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        for (Invoice i : invoices){
            System.out.println(i);
        }
    }
    private String word;
    public void myDictionary(){
        word = "-1";
        Scanner sc = new Scanner(System.in);

        while (!word.equals("")) {
            System.out.print("Enter Invoice ID: ");
            word = sc.nextLine();
            if(!word.equals("")) {
                fileWord("Invoice Number: " + word);
            }
        }
    }
    public void fileWord(String word){
        try {
            FileInputStream fileInputStream = new FileInputStream("invoice.txt");
            Scanner sc = new Scanner(fileInputStream);
            String line;
            String meanNing;
            boolean wordFound = false;
            while ((line = sc.nextLine()) != null){
                if(line.contains(word)){
                    wordFound = true;
                    System.out.println(line);
                    while (!(meanNing = sc.nextLine()).equals("")){
                        System.out.println(meanNing);
                    }
                    break;
                }
            }
            if(!wordFound) System.out.println("Word not found!");
            sc.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Word not found");
        }
    }

    @Override
    public void menu(String display) {
        String option = "-1";
        while (!option.equals("0")){
            showMenu();
            System.out.print("Enter option: ");
            option = sc.nextLine();
            option(option);
        }
    }

    private void option(String option) {
        switch (option) {
            case "1":
                add();
                break;
            case "2":
                update();
                break;
            case "3":
                remove();
                break;
            case "4":
                search();
                break;
            case "5":
                displayAll();
                break;
            case "6":
                myDictionary();
                break;
//            case "7":
//                readAllFromFile();
//                break;
//            case "8":
//                saveAllToFile();
//                break;
            case "0":
                break;
        }
    }

    private static void showMenu() {
        System.out.println("1. add ");
        System.out.println("2. update ");
        System.out.println("3. remove ");
        System.out.println("4. search ");
        System.out.println("5. displayAll ");
        System.out.println("6. Enter search Invoice ID: ");
//        System.out.println("7. readAllFromFile: ");
//        System.out.println("8. saveAllToFile: ");
        System.out.println("0. exit ");
    }
}

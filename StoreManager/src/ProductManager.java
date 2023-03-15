import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager extends Menu implements learnAble{
    static List<Product> products;
    static Scanner sc= new Scanner(System.in);
    public ProductManager(){
        products = new ArrayList<>();
//        Product c1 = new Product("p001", "iphone", 1000, true);
//        Product c2 = new Product("p002", "samsung", 3000, true);
//        Product c3 = new Product("p003", "Asus rog phone", 500, true);
//        products.add(c1);
//        products.add(c2);
//        products.add(c3);
        readFromFile();
    }

    @Override
    public void add() {
        try {
            Product newProducts = input();
            products.add(newProducts);
            saveToFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveToFile() {
        try {
            FileWriter fileWriter = new FileWriter("product.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : products) {
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFromFile(){
        products.clear();
        try {
            FileReader fileReader = new FileReader("product.txt");
            Scanner sc = new Scanner(fileReader);
            String line = "";
            while(sc.hasNextLine()){
                line = sc.nextLine();
                Product newProduct = xuLyLine(line);
                if(newProduct != null){
                    products.add(newProduct);
                }
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Product xuLyLine(String line) {
        try {
            String[] ss = line.split(",");
            Product p = new Product(ss[0],ss[1],Double.parseDouble(ss[2]),Boolean.parseBoolean(ss[3]));
            return p;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private Product input() {
        System.out.println("Enter product Id");
        String id = sc.next();
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter price");
        int price = sc.nextInt();

        Product newProduct = new Product(id, name, price, true);
        return newProduct;
    }

    @Override
    public void update() {
        System.out.println("Enter search Id");
        String fix = sc.next();
        for (Product p : products){
            if(p.getProductID().equals(fix)){
                System.out.println("Enter price edit");
                int fixPrice = sc.nextInt();
                p.setPrice(fixPrice);
                System.out.println(p);
            }
        }
        saveToFile();
    }

    @Override
    public void remove() {
        System.out.println("Enter search Id");
        String remove = sc.next();
        for (Product p : products){
            if(p.getProductID().equals(remove)){
                products.remove(p);
                break;
            }
        }
        saveToFile();
    }

    @Override
    public void search() {
        System.out.println("Enter search Id");
        String search = sc.next();
        Product searchProduct = searchById(search);;
        if(searchProduct != null){
            System.out.println(searchProduct);
        }
        else{
            System.out.println("Product not found");
        }
    }

    public Product searchById(String productID) {
        for (Product p : products) {
            if(p.getProductID().equals(productID)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class InventoryManager extends Menu implements learnAble {
    Scanner sc = new Scanner(System.in);
    List<Inventory> inventories;
    public InventoryManager() {
        inventories = new ArrayList<>();
        readAllFile();
    }

    @Override
    public void add() {
       try {
           Inventory i = input();
           inventories.add(i);
           saveAllToFile();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    private void saveAllToFile() {
        try {
            FileWriter fileWriter = new FileWriter("inventory.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Inventory i : inventories){
                bufferedWriter.write(i.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readAllFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream("inventory.txt");
            Scanner scanner = new Scanner(fileInputStream);
            String line = "";
            while (scanner.hasNextLine()){
                line = sc.nextLine();
                Inventory newInventory = xuLyLine(line);
                if(newInventory != null)
                    inventories.add(newInventory);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Inventory xuLyLine(String line) {
        try {
            String[] ss = line.split(",");
            Inventory newInventory = new Inventory(ss[0], ss[1], new Date(ss[3]));
            return newInventory;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Inventory input(){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter quantity: ");
        String quantity = sc.nextLine();

        Inventory newInventory = new Inventory(name, quantity, new Date());
        return newInventory;
    }
    @Override
    public void update() {
        System.out.print("Enter Product Name: ");
        String search = sc.nextLine();
        Inventory  updateQuantity = searchName(search);
        if(updateQuantity != null) {
            System.out.print("Enter quantity edit: ");
            String edit = sc.nextLine();
            updateQuantity.setQuantity(edit);
        }
        saveAllToFile();
    }


    @Override
    public void remove(){
        System.out.print("Enter Product Name: ");
        String search = sc.nextLine();
        Inventory removeProduct = searchName(search);
        if(removeProduct != null)
           inventories.remove(removeProduct);
        saveAllToFile();
    }

    public Inventory searchName(String search){
        for (Inventory i : inventories){
            if(i.getProductName().equals(search)){
                return i;
            }
        }
        return null;
    }
    @Override
    public void search() {
        System.out.print("Enter Product Name: ");
        String search = sc.nextLine();
        Inventory searchName = searchName(search);
        if(searchName != null)
            System.out.println(searchName);
    }

    @Override
    public void displayAll() {
        for (Inventory i : inventories){
            System.out.println(i);
        }
    }
}

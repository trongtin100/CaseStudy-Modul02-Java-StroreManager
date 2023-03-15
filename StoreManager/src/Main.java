import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        learnAble pM = new ProductManager();
        learnAble cM = new CustomerManagement();
        learnAble iM = new InvoiceManager();
        learnAble eM = new EmployeeManager();
        learnAble inventoryM = new InventoryManager();
        Scanner sc = new Scanner(System.in);

        int option = -1;

        while (option != 0){
            showMenu();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    pM.menu("Product Manager");
                    break;
                case 2:
                    cM.menu("Customer Management");
                    break;
                case 3:
                    iM.menu("Invoice Management");
                    break;
                case 4:
                    eM.menu("Employee Management");
                    break;
                case 5:
                    inventoryM.menu("Inventory Management");
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Product Manager");
        System.out.println("2. Customer Management");
        System.out.println("3. Invoice Management");
        System.out.println("4. Employee Management");
        System.out.println("5. Inventory Management");
        System.out.println("0. exit");
        System.out.print("Enter option: ");
    }
}
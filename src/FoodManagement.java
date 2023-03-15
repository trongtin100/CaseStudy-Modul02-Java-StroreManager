import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FoodManagement implements ManagerAble {
    Scanner scanner = new Scanner(System.in);
    List <Food> foods;
    


    public FoodManagement(){
        foods = new ArrayList<>();
        Food foodNumber1 = new Food("Ca01", "Cá Ngừ",200000);
        Food foodNumber2 = new Food("Ca02", "Cá Ngừ",300000);
        foods.add(foodNumber1);
        foods.add(foodNumber2);
    }

    // Enter new food.
    public Food input(){
        System.out.print("Add new foodID : ");
        String foodID = scanner.next();
        System.out.print("Add new foodName: ");
        String foodName = scanner.next();
        double foodPrice = scanner.nextDouble();

        Food newFood = new Food(foodID, foodName,foodPrice);
        return newFood;
    }

    //Add new foods.
    public void add(){
        Food addFood = input();
        foods.add(addFood);
    }

    //SearchByID
    public Food searchByID(String searchID){
        for(Food f : foods){
            if(f.getFoodID().equals(searchID)) return f;
        }
        return null;
    }


    //Search food name by ID.
    @Override
    public void search() {
        System.out.print("Enter foodID: ");
        String searchID = scanner.next();

        Food searchFood = searchByID(searchID);
        System.out.print(searchFood.toString());
    }

    @Override
    public void update() {
        System.out.print("Enter new foodID: ");
        String searchID = scanner.next();
        System.out.print("Enter new foodID: ");
        String newID = scanner.next();
        System.out.print("Enter new foodName: ");
        String newName = scanner.next();
        System.out.print("Enter new foodPrice: ");
        Double foodPrice = scanner.nextDouble();

        Food updateFood = searchByID(searchID);
        updateFood.setFoodID(newID);
        updateFood.setFoodName(newName);
        updateFood.setFoodPrice(foodPrice);
    }

    @Override
    public void remove() {
        System.out.print("Enter foodID to remove: ");
        String searchID = scanner.next();

        Food removeFood = searchByID(searchID);
        foods.remove(removeFood); 
    }
}

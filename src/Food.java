import java.util.Scanner;

public class Food {
    private String foodID;
    private String foodName;
    private double foodPrice;

    Scanner scanner = new Scanner(System.in);
    

    public Food(String foodID, String foodName , double foodPrice) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public void setFoodPrice(double foodPrice){this.foodPrice = foodPrice;}
    public double getFoodPrice(){return this.foodPrice;}

    public String getFoodID() {return foodID;}
    public void setFoodID(String foodID) {this.foodID = foodID;}

    public String getFoodName() {return foodName;}
    public void setFoodName(String foodName) { this.foodName = foodName;}

    @Override
    public String toString() {
        return "Food [foodID=" + foodID + ", foodName=" + foodName + ", foodPrice=" + foodPrice + "]";
    }

    
}

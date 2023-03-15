public class SurchargeTable {
    public static final Integer Discount = 5000000;
    
    public static double getSurchargeTable(TableType tableType) {
        if(tableType.equals(TableType.VIP))
            return 1.1;
        return 1.0;
        
    }

    //Discount Bill
    public static double discountBill(double total){
        if(total > 5000000){
            return 0.9;
        }
        return 1;
    }
    
}

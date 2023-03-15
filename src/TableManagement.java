import java.util.ArrayList;
import java.util.List;

public class TableManagement {
    List< Table > tables;

    public TableManagement(){
        tables = new ArrayList<>();
        Table b1 = new Table("A01", TableType.Normal, true);
        Table b2 = new Table("A02",TableType.Normal, true);
        Table b3 = new Table("V01", TableType.VIP, true);
        Table b4 = new Table("V04", TableType.VIP, true);

        tables.add(b1);
        tables.add(b2);
        tables.add(b3);
        tables.add(b4);
    }
    //check empty or full
    public void checkEmptyTable(){
        for(Table t : tables){
            if(t.isStatus()){
                System.out.println(t.toString());
            }
        }
    }
    //Check full by invoiceID
   public boolean checkIn(String invoiceID){
        for(Table t : tables){
           if(invoiceID != ""){
                t.setStatus(false);
           }
        }
        return true;
   }
   
}

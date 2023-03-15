import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
    private String name;
    private String id;
    private Date date;
    private boolean check;

    public Employee(String name, String id,Date date, boolean check) {
        this.date = date;
        this.name = name;
        this.id = id;
        this.check = check;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy-hh:mm:ss");
        return name + "," + id + "," + format.format(this.date) + "," + check;
    }
}

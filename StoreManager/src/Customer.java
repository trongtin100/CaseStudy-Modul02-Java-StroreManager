public class Customer {
    private String cusID;
    private String name;
    private String phone;
    private String address;

    public Customer(String cusID, String name, String phone, String address) {
        this.cusID = cusID;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }


    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.cusID + "," + this.name + "," + this.phone + "," + this.address ;
    }
}

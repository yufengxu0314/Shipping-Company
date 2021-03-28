package model;

public class Customer {

    private String PhoneNumber;
    private String Name;
    private String Address;

    public Customer(String PhoneNumber, String Name, String Address){
        this.PhoneNumber = PhoneNumber;
        this.Name = Name;
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getName() {
        return Name;
    }


    public String getAddress() {
        return Address;
    }
}

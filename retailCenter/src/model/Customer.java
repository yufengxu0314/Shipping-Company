package model;

public class Customer {

    private String PhoneNumber;
    private String Name;
    private String UserName;
    private String Password;
    private String Address;

    public Customer(String PhoneNumber, String Name, String UserName, String Password, String Address){
        this.PhoneNumber = PhoneNumber;
        this.Name = Name;
        this.UserName = UserName;
        this.Password = Password;
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getName() {
        return Name;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getAddress() {
        return Address;
    }
}

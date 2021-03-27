package model;

public class Customer {

    public String PhoneNumber;
    public String Name;
    public String UserName;
    public String Password;
    public String Address;

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


}

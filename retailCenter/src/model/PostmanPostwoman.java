package model;

public class PostmanPostwoman extends Staff {

    public int PhoneNumber;

    public PostmanPostwoman(int StaffID, int BranchNumber, int PhoneNumber) {
        super(StaffID, BranchNumber);
        this.PhoneNumber = PhoneNumber;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }
}

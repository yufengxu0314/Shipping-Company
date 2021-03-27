package model;

public class RetailCenter {
    public int BranchNumber;
    public String Address;

    public RetailCenter(int BranchNumber, String Address) {
        this.Address = Address;
        this.BranchNumber = BranchNumber;
    }
    public int getBranchNumber() {
        return BranchNumber;
    }

    public String getAddress() {
        return Address;
    }
}

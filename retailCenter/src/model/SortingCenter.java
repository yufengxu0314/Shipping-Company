package model;

public class SortingCenter {
    public int BranchNumber;
    public String Address;

    public SortingCenter(int BranchNumber, String Address) {
        this.BranchNumber = BranchNumber;
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }

    public int getBranchNumber() {
        return BranchNumber;
    }
}

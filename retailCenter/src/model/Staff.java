package model;
import model.RetailCenter;

public class Staff {
    public int StaffID;
    public int BranchNumber;
    private RetailCenter retailCenter;

    public Staff(int StaffID) {
        this.BranchNumber = retailCenter.BranchNumber;
        this.StaffID = StaffID;
    }

    public int getStaffID() {
        return StaffID;
    }

    public int getBranchNumber() {
        return BranchNumber;
    }
}

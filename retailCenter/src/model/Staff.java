package model;
import model.RetailCenter;

public class Staff {
    public int StaffID;
    public int BranchNumber;
    private RetailCenter retailCenter;

    public Staff(int StaffID, RetailCenter retailCenter) {
        this.retailCenter = retailCenter;
        this.BranchNumber = retailCenter.getBranchNumber();
        this.StaffID = StaffID;
    }

    public int getStaffID() {
        return StaffID;
    }

    public int getBranchNumber() {
        return BranchNumber;
    }
}

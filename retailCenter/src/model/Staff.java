package model;
import model.RetailCenter;

public class Staff {
    public int StaffID;
    public int BranchNumber;

    public Staff(int StaffID, int BranchNumber) {
        this.BranchNumber = BranchNumber;
        this.StaffID = StaffID;
    }

    public int getStaffID() {
        return StaffID;
    }

    public int getBranchNumber() {
        return BranchNumber;
    }
}

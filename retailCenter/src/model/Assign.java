package model;

public class Assign {

    private int BranchNumber;
    private int StaffID;
    private int TrackingID;

    public Assign(int BranchNumber, int StaffID, int TrackingID) {
        this.BranchNumber = BranchNumber;
        this.StaffID = StaffID;
        this.TrackingID = TrackingID;
    }

    public int getBranchNumber() {
        return BranchNumber;
    }

    public int getTrackingID() {
        return TrackingID;
    }

    public int getStaffID() {
        return StaffID;
    }
}

package model;

public class Transportation {

    private int BranchNumber;
    private int TrackingID;
    private int StaffID;

    public Transportation (int BranchNumber, int TrackingID, int StaffID) {
        this.BranchNumber = BranchNumber;
        this.TrackingID = TrackingID;
        this.StaffID = StaffID;
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

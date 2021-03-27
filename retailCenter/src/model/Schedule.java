package model;

public class Schedule {

    private int BranchNumber;
    private int TrackingID;

    public Schedule (int BranchNumber, int TrackingID) {
        this.BranchNumber = BranchNumber;
        this.TrackingID = TrackingID;
    }

    public int getBranchNumber() {
        return BranchNumber;
    }

    public int getTrackingID() {
        return TrackingID;
    }
}

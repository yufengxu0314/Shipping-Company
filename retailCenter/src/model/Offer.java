package model;

public class Offer {
    private int BranchNumber;
    private int TrackingID;

    public Offer (int BranchNumber, int TrackingID) {
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

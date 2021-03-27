package model;

public class Insurance {

    private int TrackingID;
    private int Amount;
    private String SenderPhoneNumber;

    public Insurance (int TrackingID, int Amount, String SenderPhoneNumber) {
        this.Amount = Amount;
        this.SenderPhoneNumber = SenderPhoneNumber;
        this.TrackingID = TrackingID;
    }

    public int getTrackingID() {
        return TrackingID;
    }

    public int getAmount() {
        return Amount;
    }

    public String getSenderPhoneNumber() {
        return SenderPhoneNumber;
    }
}

package model;

public class Parcel {
    private Sender sender;
    public String SenderPhoneNumber;
    public String ReceiveTime;
    public String SenderName;

    public Parcel(String ReceiveTime, Sender sender) {
        this.sender = sender;
        this.ReceiveTime = ReceiveTime;
        this.SenderName = sender.getName();
        this.SenderPhoneNumber = sender.getPhoneNumber();
    }

    public Sender getSender() {
        return sender;
    }

    public String getReceiveTime() {
        return ReceiveTime;
    }

    public String getSenderName() {
        return SenderName;
    }
}

package model;

public class ReceivedBy {

    public int BranchNumber;
    public String ReceiveTime;
    public String PhoneNumber;

    public ReceivedBy(int BranchNumber, String ReceiveTime, String PhoneNumber) {
        this.BranchNumber = BranchNumber;
        this.ReceiveTime = ReceiveTime;
        this.PhoneNumber = PhoneNumber;
    }

    public int getBranchNumber() {
        return BranchNumber;
    }

    public String getReceiveTime() {
        return ReceiveTime;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
}

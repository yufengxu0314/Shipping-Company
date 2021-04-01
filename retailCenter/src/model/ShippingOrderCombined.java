package model;

public class ShippingOrderCombined {
    private int TrackingID;
    private String ContentType;
    private String OrderDate;
    private int Weight;
    private String Size;
    private String ShippingMethod;
    private int Price;
    private String Sender_phoneNum;
    private String Receiver_phoneNum;
    private String Sender_name;




    public ShippingOrderCombined(int TrackingID, String ContentType, String OrderDate,
                                 int Weight, String Size, String ShippingMethod, int Price, String Sender_phoneNum, String Receiver_phoneNum, String SenderName) {
        this.ContentType = ContentType;
        this.TrackingID = TrackingID;
        this.OrderDate = OrderDate;
        this.Weight = Weight;
        this.ShippingMethod = ShippingMethod;
        this.Size = Size;
        this.Price = Price;
        this.Sender_phoneNum = Sender_phoneNum;
        this.Receiver_phoneNum = Receiver_phoneNum;
        this.Sender_name = SenderName;
    }

    public int getPrice() {
        return Price;
    }

    public int getTrackingID() {
        return TrackingID;
    }

    public int getWeight() {
        return Weight;
    }

    public String getContentType() {
        return ContentType;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public String getShippingMethod() {
        return ShippingMethod;
    }

    public String getSize() {
        return Size;
    }

    public String getSender_phoneNum() {
        return Sender_phoneNum;
    }

    public String getReceiver_phoneNum() {
        return Receiver_phoneNum;
    }

    public String getSender_name() {
        return Sender_name;
    }

    //public String getReceiverAddress() {
        //return ReceiverAddress;
    //}
}

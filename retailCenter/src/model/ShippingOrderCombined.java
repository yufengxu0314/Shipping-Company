package model;

public class ShippingOrderCombined {
    private int TrackingID;
    private String ContentType;
    private String OrderDate;
    private int Weight;
    private String Size;
    private String ShippingMethod;
    private int Price;
    private String SenderPhoneNumber;
    private String SenderName;



    public ShippingOrderCombined(int TrackingID, String ContentType, String OrderDate,
                         int Weight, String Size, String ShippingMethod, int Price, String SenderPhoneNumber,String senderName) {
        this.ContentType = ContentType;
        this.TrackingID = TrackingID;
        this.OrderDate = OrderDate;
        this.Weight = Weight;
        this.ShippingMethod = ShippingMethod;
        this.Size = Size;
        this.Price = Price;
        this.SenderPhoneNumber = SenderPhoneNumber;
        this.SenderName = senderName;
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

    public String getSenderPhoneNumber() {
        return SenderPhoneNumber;
    }

    public String getSenderName() {
        return SenderName;
    }
}

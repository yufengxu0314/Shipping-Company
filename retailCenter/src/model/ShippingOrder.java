package model;

public class ShippingOrder {
    public int TrackingID;
    public String ContentType;
    public String OrderDate;
    public int Weight;
    public String Size;
    public String ShippingMethod;
    public int Price;
    public String SenderPhoneNumber;

    public ShippingOrder(int TrackingID, String ContentType, String OrderDate,
                         int Weight, String Size, String ShippingMethod, int Price, String SenderPhoneNumber) {
        this.ContentType = ContentType;
        this.TrackingID = TrackingID;
        this.OrderDate = OrderDate;
        this.Weight = Weight;
        this.ShippingMethod = ShippingMethod;
        this.Size = Size;
        this.Price = Price;
        this.SenderPhoneNumber = SenderPhoneNumber;
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
}

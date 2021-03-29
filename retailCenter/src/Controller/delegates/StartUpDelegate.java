package Controller.delegates;

import exception.exception;
import model.Customer;
import model.ShippingOrder;

/**
 * This interface uses the delegation design pattern where instead of having
 * the TerminalTransactions class try to do everything, it will only
 * focus on handling the UI. The actual logic/operation will be delegated to the 
 * controller class (in this case Bank).
 * 
 * TerminalTransactions calls the methods that we have listed below but 
 * Bank is the actual class that will implement the methods.
 */
public interface StartUpDelegate {
	public void addCustomer(String PhoneNumber, String Name, String Address);
	public void addOrders(int TrackingID, String ContentType, String OrderDate,
						  int Weight, String Size, String ShippingMethod, int Price);
	public void deleteOrder(int TrackingID);
	public void updateCustomer(String Name, String PhoneNumber, String Address);
	public void searchCustomer(String PhoneNumber) throws exception;
	public ShippingOrder searchTracking(int TrackingID) throws exception;
	public void databaseSetup();
	public void finish();
}

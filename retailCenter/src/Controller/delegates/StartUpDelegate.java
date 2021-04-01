package Controller.delegates;

import exception.exception;
import model.Customer;
import model.ShippingOrder;
import model.ShippingOrderCombined;

import java.sql.SQLException;
import java.util.ArrayList;

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
	public void addCustomer(Customer customer) throws SQLException;
	public void addOrders(ShippingOrder s);
	public void deleteOrder(int TrackingID);
	public void updateCustomer(String PhoneNumber, String Address,  String Name);
	public Customer searchCustomer(String PhoneNumber);
	public ShippingOrder searchTracking(int TrackingID) throws exception;
	public void databaseSetup();
	public void finish();
	public ArrayList<String> getLoyaltyCustomer();
	public int getDailyCount(String date);
	public ArrayList<String> getCreateAfter(String date);
	public ArrayList<ShippingOrderCombined> findSender(String date);
	public ArrayList<Customer> findMoreThan();
}


package Controller;

import Controller.delegates.LoginWindowDelegate;
import Controller.delegates.StartUpDelegate;
import database.DatabaseHandler;
import exception.exception;
import model.Customer;
import model.ShippingOrder;
import model.ShippingOrderCombined;
import ui.main_frame.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller implements StartUpDelegate, LoginWindowDelegate {
    private DatabaseHandler databaseHandler;
    private LoginWindow loginWindow = null;
    public RC_Frame rc_frame;

    public Controller() {
        databaseHandler = new DatabaseHandler();
    }


    public void start() {
        loginWindow = new LoginWindow();
        loginWindow.showFrame(this);
    }


    @Override
    public void login(String username, String password) {
        boolean didConnect = databaseHandler.login(username, password);
        if (didConnect) {
            loginWindow.dispose();
            rc_frame = new RC_Frame();
            rc_frame.setupDatabase(this);
//            try {
//                addCustomer("321312", "32131", "34123123");
//                System.out.println("successful");
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
        } else {
            System.out.println("failed");
            System.exit(-1);
        }
    }


    @Override
    public void addCustomer(Customer customer) throws SQLException {
        databaseHandler.addCustomer(customer);
    }

    @Override
    public void addOrders(ShippingOrder s) {
        databaseHandler.addOrders(s);
    }

    @Override
    public void deleteOrder(int TrackingID) {
        databaseHandler.deleteOrder(TrackingID);
    }

    @Override
    public void updateCustomer(String PhoneNumber, String Address, String Name) {
        databaseHandler.updateCustomer(PhoneNumber, Address, Name);
    }

    @Override
    public Customer searchCustomer(String PhoneNumber) throws exception {
        return databaseHandler.searchCustomer(PhoneNumber);
    }

    @Override
    public ShippingOrder searchTracking(int TrackingID) throws exception {
        return databaseHandler.searchTracking(TrackingID);
    }

    @Override
    public ArrayList<String> getLoyaltyCustomer(){
        return databaseHandler.getLoyaltyCustomer();
    }
    @Override
    public int getDailyCount(String date) {
        return databaseHandler.getDailyCount(date);
    }
    @Override
    public ArrayList<ShippingOrderCombined> findSender(String date) {
        return databaseHandler.findSender(date);
    }

    public void databaseSetup() {
//        databaseHandler.databaseSetup();;
    }

    @Override
    public void finish() {
        databaseHandler.close();
        databaseHandler = null;

        System.exit(0);
    }


    public static void main(String args[]) {
        Controller controller = new Controller();
        controller.start();
    }
}

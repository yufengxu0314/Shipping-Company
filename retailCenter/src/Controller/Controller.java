package Controller;

import Controller.delegates.LoginWindowDelegate;
import Controller.delegates.StartUpDelegate;
import database.DatabaseHandler;
import exception.exception;
import model.Customer;
import model.ShippingOrder;
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
    public void addCustomer(String PhoneNumber, String Name, String Address) throws SQLException {
        databaseHandler.addCustomer(PhoneNumber, Name, Address);
    }

    @Override
    public void addOrders(int TrackingID, String ContentType, String OrderDate, int Weight, String Size, String ShippingMethod, int Price, String SenderPhone) {
        databaseHandler.addOrders(TrackingID, ContentType, OrderDate, Weight, Size, ShippingMethod, Price, SenderPhone);
    }

    @Override
    public void deleteOrder(int TrackingID) {
        databaseHandler.deleteOrder(TrackingID);
    }

    @Override
    public void updateCustomer(String Name, String PhoneNumber, String Address) {
        databaseHandler.updateCustomer(Name, PhoneNumber, Address);
    }

    @Override
    public ArrayList<String> searchCustomer(String PhoneNumber) throws exception {
        return databaseHandler.searchCustomer(PhoneNumber);
    }

    @Override
    public ShippingOrder searchTracking(int TrackingID) throws exception {
        return databaseHandler.searchTracking(TrackingID);
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

package Controller;

import Controller.delegates.LoginWindowDelegate;
import Controller.delegates.StartUpDelegate;
import database.databaseHandler;
import exception.exception;
import model.ShippingOrder;
import ui.main_frame.*;

public class Controller implements StartUpDelegate, LoginWindowDelegate {
    private databaseHandler databaseHandler;
    private LoginWindow loginWindow = null;


    public Controller() {
        databaseHandler = new databaseHandler();
    }


    private void start() {
        loginWindow = new LoginWindow();
        loginWindow.showFrame(this);
    }


    @Override
    public void login(String username, String password) {
        databaseHandler.login(username, password);
        boolean didConnect = databaseHandler.login(username, password);
        if (didConnect) {
            loginWindow.dispose();
            databaseSetup();
            RC_Frame rc_frame = new RC_Frame();
            rc_frame.set_frame();
        } else {
            System.out.println("failed");
            System.exit(-1);
        }
    }


    @Override
    public void addCustomer(String PhoneNumber, String Name, String Address) {
        databaseHandler.addCustomer(PhoneNumber, Name, Address);
    }

    @Override
    public void addOrders(int TrackingID, String ContentType, String OrderDate, int Weight, String Size, String ShippingMethod, int Price) {
        databaseHandler.addOrders(TrackingID, ContentType, OrderDate, Weight, Size, ShippingMethod, Price);
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
    public void searchCustomer(String PhoneNumber) throws exception {
        databaseHandler.searchCustomer(PhoneNumber);
    }

    @Override
    public ShippingOrder searchTracking(int TrackingID) throws exception {
        return databaseHandler.searchTracking(TrackingID);
    }

    public void databaseSetup() {
        databaseHandler.databaseSetup();;
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

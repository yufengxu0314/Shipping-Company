package database;

import exception.exception;
import model.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class databaseHandler {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    private Connection connection = null;

    public databaseHandler() {
        try {
            // Load the Oracle JDBC driver
            // Note that the path could change for new drivers
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
        }
    }


        public boolean login (String username, String password) {
            try {
                if (connection != null) {
                    connection.close();
                }

                connection = DriverManager.getConnection(ORACLE_URL, username, password);
                connection.setAutoCommit(false);

                System.out.println("\nConnected to Oracle!");
                return true;
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
                return false;
            }
        }

        private void rollbackConnection() {
            try  {
                connection.rollback();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }

        public void databaseSetup() {
            dropBranchTableIfExists();

            try {
                Statement stmt = connection.createStatement();
                stmt.executeUpdate("CREATE TABLE branch (branch_id integer PRIMARY KEY, branch_name varchar2(20) not null, branch_addr varchar2(50), branch_city varchar2(20) not null, branch_phone integer)");
                stmt.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }

            getCustomer();
            getSender();
            getReceiver();
            getParcel();
            getRetailCenter();
            getShippingOrder();
            getStaff();
//            getInsurance();
//            getOffer();
//            getReceivedBy();
//            getSchedule();
//            getCourrier();
//            getPostman/Postwoman();
//            getSortingCenter();
//            getTransportation();
//            getAssign();

        }

    public ArrayList<Customer> getCustomer() {
        ArrayList<Customer> customer = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
            while(rs.next()) {
                Customer c = new Customer(rs.getString("PhoneNumber"), rs.getString("Name"),
                        rs.getString("UserName"), rs.getString("Password"), rs.getString("Address"));
                customer.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(customer);
        return customer;
    }

    public ArrayList<Sender> getSender() {
        ArrayList<Sender> sender = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Sender");
            while(rs.next()) {
                Sender s = new Sender(rs.getString("PhoneNumber"), rs.getString("Name"),
                        rs.getString("UserName"), rs.getString("Password"), rs.getString("Address"));
                sender.add(s);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sender);
        return sender;
    }

    public ArrayList<Receiver> getReceiver() {
        ArrayList<Receiver> receiver = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Receiver");
            while(rs.next()) {
                Receiver r = new Receiver(rs.getString("PhoneNumber"), rs.getString("Name"),
                        rs.getString("UserName"), rs.getString("Password"), rs.getString("Address"));
                receiver.add(r);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(receiver);
        return receiver;
    }

    public ArrayList<ShippingOrder> getShippingOrder() {
        ArrayList<ShippingOrder> shippingOrder = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ShippingOrder");
            while(rs.next()) {
                ShippingOrder so = new ShippingOrder(rs.getInt("TrackingID"),
                                                    rs.getString("ContentType"),
                                                    rs.getString("OrderDate"),
                                                    rs.getInt("Weight"),
                                                    rs.getString("Size"),
                                                    rs.getString("ShippingMethod"),
                                                    rs.getInt("Price"));
                shippingOrder.add(so);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(shippingOrder);
        return shippingOrder;
    }

    public ArrayList<RetailCenter> getRetailCenter() {
        ArrayList<RetailCenter> retailCenter = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM RetailCenter");
            while(rs.next()) {
                RetailCenter r = new RetailCenter( rs.getInt("BranchNumber"),rs.getString("Address"));
                retailCenter.add(r);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(retailCenter);
        return retailCenter;
    }

    public ArrayList<Staff> getStaff() {
        ArrayList<Staff> staff = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");
            while(rs.next()) {
                Staff s = new Staff(rs.getInt("StaffID"), rs.getInt("BranchNumber"));
                staff.add(s);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(staff);
        return staff;
    }

    public ArrayList<Parcel> getParcel() {
        ArrayList<Parcel> parcel = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Parcel");
            while(rs.next()) {
                Parcel p = new Parcel(rs.getString("ReceiveTime"), (Sender) rs.getObject("sender"));
                parcel.add(p);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(parcel);
        return parcel;
    }

    //Queries: INSERT Operation
    public void addCustomer(String PhoneNumber, String Name, String UserName, String Password, String Address) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?)");
            ps.setString(1, PhoneNumber);
            ps.setString(2, Name);
            ps.setString(3, UserName);
            ps.setString(4, Password);
            ps.setString(5, Address);

            ps.executeUpdate();
            connection.commit();
            ps.close();
            getCustomer();
        } catch (SQLException e) {
            System.out.println("ERROR");
            rollbackConnection();
        }
    }

    //Queries: INSERT Operation
    public void addOrders(int TrackingID, String ContentType, String OrderDate,
                             int Weight, String Size, String ShippingMethod, int Price) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, TrackingID);
            ps.setString(2, ContentType);
            ps.setString(3, OrderDate);
            ps.setInt(4, Weight);
            ps.setString(5, Size);
            ps.setString(6, ShippingMethod);
            ps.setInt(7, Price);
            ps.executeUpdate();
            connection.commit();
            ps.close();
            getCustomer();
        } catch (SQLException e) {
            System.out.println("ERROR");
            rollbackConnection();
        }
    }

    //Queries: DELETE Operation
    public void deleteOrder(int TrackingID) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM ShippingOrder WHERE TrackingID = ?");
            ps.setInt(1, TrackingID);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println(WARNING_TAG + " Order " + TrackingID + " does not exist!");
            }

            connection.commit();

            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }

    //Queries: UPDATE Operation
    public void updateCustomer(String Name, String PhoneNumber, String Address) {
        try {
            getCustomer();
            PreparedStatement ps = connection.prepareStatement("UPDATE Customer SET PhoneNumber = ?, Name = ? WHERE Address = ?");
            ps.setString(1, PhoneNumber);
            ps.setString(2, Name);
            ps.setString(3, Address);

            int rowCount = ps.executeUpdate();
            if (rowCount == 0) {
                System.out.println("ERROR" + " Customer with address " + Address + " does not exist!");
            }
            connection.commit();
            ps.close();
            getCustomer();
        } catch (SQLException e) {
            System.out.println("ERROR");
            rollbackConnection();
        }
    }



    //
    public void searchCustomer(String PhoneNumber, String Name, String UserName, String Password, String Address) throws exception {

        ArrayList<Customer> result = new ArrayList<Customer>();


    }


    private void dropBranchTableIfExists(){
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select table_name from user_tables");

                while(rs.next()) {
                    if(rs.getString(1).toLowerCase().equals("branch")) {
                        stmt.execute("DROP TABLE branch");
                        break;
                    }
                }

                rs.close();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            }
        }





    }

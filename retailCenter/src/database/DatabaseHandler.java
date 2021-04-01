package database;

import exception.exception;
import model.*;

import javax.naming.Name;
import javax.swing.plaf.nimbus.State;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class DatabaseHandler {
    private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
    private static final String EXCEPTION_TAG = "[EXCEPTION]";
    private static final String WARNING_TAG = "[WARNING]";

    public Connection connection = null;
    public PreparedStatement ps = null;



    public DatabaseHandler() {
        try {
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



//    public void databaseSetup() {
//
//            getCustomer();
////            getSender();
////            getReceiver();
////            getParcel();
////            getRetailCenter();
////            getShippingOrder();
////            getStaff();
////            getInsurance();
////            getOffer();
////            getReceivedBy();
////            getSchedule();
////            getCourier();
////            getPostmanPostwoman();
////            getSortingCenter();
////            getTransportation();
////            getAssign();
//
//        }

    //Queries: INSERT Operation
    public void addCustomer(Customer c) throws SQLException {
        try {
            System.out.print("This line can run");
            ps = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?)");
            ps.setString(1, c.getPhoneNumber());
            ps.setString(2, c.getName());
            ps.setString(3, c.getAddress());
            System.out.print("Success");
            ps.executeUpdate();
            connection.commit();
            System.out.println("Commit successful");
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
//            rollbackConnection();
        }
    }


    //Queries: INSERT Operation
    public void addOrders(ShippingOrder s) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO shippingorder VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, s.getTrackingID());
            ps.setString(2, s.getContentType());
            ps.setString(3, s.getOrderDate());
            ps.setInt(4, s.getWeight());
            ps.setString(5, s.getSize());
            ps.setString(6, s.getShippingMethod());
            ps.setInt(7, s.getPrice());
            ps.setString(8, s.getSender());
            ps.setString(9, s.getReceiver());
            System.out.print("Success");
            ps.executeUpdate();
            connection.commit();
            System.out.println("Commit successful");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR");
//            rollbackConnection();
        }
    }

    //Queries: DELETE Operation
    public void deleteOrder(int TrackingID) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM shippingorder WHERE TrackingID = " + TrackingID);
            ps.setInt(1, TrackingID);
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            System.out.println(EXCEPTION_TAG + " " + e.getMessage());
            rollbackConnection();
        }
    }


    //Queries: UPDATE Operation
    public void updateCustomer(String PhoneNumber, String Address, String Name) {
        try {
            Statement s = connection.createStatement();
            s.executeQuery("UPDATE Customer SET Address = " + "'" +Address+ "'" + "WHERE PhoneNumber = " + "'" + PhoneNumber + "'");
            connection.commit();
            s.close();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //Queries: PROJECTION Operation
    //return customer's Name and Address with given PhoneNumber
    public Customer searchCustomer(String PhoneNumber) throws exception {
        Customer a = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Name, Address FROM customer WHERE PhoneNumber = " + PhoneNumber);
            while(rs.next()) {
                a = new Customer(PhoneNumber, rs.getString("Name"), rs.getString("Address"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(a);
        return a;
    }

    //Queries: SELECTION Operation
    //Return the full order info with the given TrackingID
    public ShippingOrder searchTracking(int id) throws exception {
        ShippingOrder s = null;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM shippingorder WHERE TrackingID = " + id);
            //System.out.print("Success");
            while(rs.next()) {
                s = new ShippingOrder(rs.getInt("TrackingID"), rs.getString("ContentType"),
                        rs.getString("OrderDate"),
                        rs.getInt("Weight"),
                        rs.getString("PacelSize"),
                        rs.getString("ShippingMethod"),
                        rs.getInt("Price") ,
                        rs.getString("Sender"),
                        rs.getString("Receiver") );
            }
            connection.commit();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }


    //Queries: JOIN Operation
    // Find a customer who shipped on a given date
    public ArrayList<ShippingOrderCombined> findSender(String date) {
        ArrayList<ShippingOrderCombined> ret = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SHIPPINGORDER.*, R.ADDRESS, S.ADDRESS FROM ((SHIPPINGORDER INNER JOIN RECEIVER R on SHIPPINGORDER.RECEIVER = R.PHONENUMBER) INNER JOIN SENDER S on SHIPPINGORDER.SENDER = S.PHONENUMBER) WHERE SHIPPINGORDER.ORDERDATE LIKE " + "'%" + date + "%'");
            while(rs.next()) {
                ShippingOrderCombined soc = new ShippingOrderCombined(rs.getInt("TrackingID"),
                                                                      rs.getString("ContentType"),
                                                                      rs.getString("OrderDate"),
                                                                      rs.getInt("Weight"),rs.getString("PacelSize"),
                                                                      rs.getString("ShippingMethod"),
                                                                      rs.getInt("Price") ,
                                                                      rs.getString("Sender"),
                                                                      rs.getString("Receiver"),
                                                                      rs.getString("SenderAddress"),
                                                                      rs.getString("ReceiverAddress"));
                ret.add(soc);
            }
            connection.commit();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }



    //Queries: Aggregation with Group By (show today's order count)
    // Find number of orders created each day
    public int getDailyCount(String date) {
        int ret = 0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM shippingorder WHERE shippingorder.OrderDate LIKE" + "'%" + date + "%'" + "GROUP BY shippingorder.OrderDate");
            ret = rs.getInt("COUNT(*)");
            connection.commit();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ret;
    }

    //Queries: Aggregation with Having
    //Find the orders created after a specific date.



    //Queries: Nested Aggregation with Group By
    ///Find the orders created after a specific date.


    //Queries: Division （loyalty customer button）
    //Find a customer who used all types of shipping methods to ship




    public ArrayList<Customer> getCustomer() {
        ArrayList<Customer> customer = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customer");
            while(rs.next()) {
                Customer c = new Customer(rs.getString("PhoneNumber"), rs.getString("Name"), rs.getString("Address"));
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
                         rs.getString("Address"));
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM receiver");
            while(rs.next()) {
                Receiver r = new Receiver(rs.getString("PhoneNumber"), rs.getString("Name"),
                        rs.getString("Address"));
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
                                                    rs.getInt("Price"),
                                                    rs.getString("SenderPhoneNumber"),
                                                    rs.getString("ReceiverPhoneNumber") );
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



    public ArrayList<Insurance> getInsurance() {
        ArrayList<Insurance> insurances = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM insurance");
            while(rs.next()) {
                Insurance i = new Insurance(rs.getInt("TrackingID"), rs.getInt("Amount"), rs.getString("SenderPhoneNumber"));
                insurances.add(i);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(insurances);
        return insurances;
    }



    public ArrayList<Offer> getOffer() {
        ArrayList<Offer> offers = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM offer");
            while(rs.next()) {
                Offer o = new Offer(rs.getInt("BranchNumber"), rs.getInt("TrackingID"));
                offers.add(o);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(offers);
        return offers;
    }


    public ArrayList<ReceivedBy> getReceivedBy() {
        ArrayList<ReceivedBy> receivedBy = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM receivedby");
            while(rs.next()) {
                ReceivedBy r = new ReceivedBy(rs.getInt("BranchNumber"), rs.getString("ReceiveTime"), rs.getString("PhoneNumber"));
                receivedBy.add(r);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(receivedBy);
        return receivedBy;
    }


    public ArrayList<Schedule> getSchedule() {
        ArrayList<Schedule> schedules = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM schedule");
            while(rs.next()) {
                    Schedule s = new Schedule(rs.getInt("BranchNumber"), rs.getInt("TrackingID"));
                schedules.add(s);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(schedules);
        return schedules;
    }

    public ArrayList<Courier> getCourier() {
        ArrayList<Courier> couriers = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Courier");
            while(rs.next()) {
                Courier c = new Courier(rs.getInt("BranchNumber"), rs.getInt("StaffID"));
                couriers.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(couriers);
        return couriers;
    }

    public ArrayList<PostmanPostwoman> getPostmanPostwoman() {
        ArrayList<PostmanPostwoman> postmanPostwomen = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PostmanPostwoman");
            while(rs.next()) {
                PostmanPostwoman p = new PostmanPostwoman(rs.getInt("BranchNumber"), rs.getInt("StaffID"), rs.getInt("PhoneNumber"));
                postmanPostwomen.add(p);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(postmanPostwomen);
        return postmanPostwomen;
    }

    public ArrayList<SortingCenter> getSortingCenter() {
        ArrayList<SortingCenter> sortingCenters = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SortingCenter");
            while(rs.next()) {
                SortingCenter s = new SortingCenter(rs.getInt("BranchNumber"), rs.getString("Address"));
                sortingCenters.add(s);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sortingCenters);
        return sortingCenters;
    }

    public ArrayList<Transportation> getTransportation() {
        ArrayList<Transportation> transportation = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM transportation");
            while(rs.next()) {
                Transportation t = new Transportation(rs.getInt("BranchNumber"), rs.getInt("TrackingID"), rs.getInt("StaffID"));
                transportation.add(t);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(transportation);
        return transportation;
    }

    public ArrayList<Assign> getAssign() {
        ArrayList<Assign> assigns = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM assign");
            while(rs.next()) {
                Assign a = new Assign(rs.getInt("BranchNumber"), rs.getInt("TrackingID"), rs.getInt("StaffID"));
                assigns.add(a);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(assigns);
        return assigns;
    }




    public ArrayList<Parcel> getParcel() {
        ArrayList<Parcel> parcel = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM parcel");
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





    }

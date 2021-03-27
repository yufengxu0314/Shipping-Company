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
import java.util.ArrayList;import java.util.ArrayList;
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
            getInsurance();
            getOffer();
            getReceivedBy();
            getSchedule();
            getCourrier();
            getPostman/Postwoman();
            getSortingCenter();
            getTransportation();
            getAssign();

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




        private void dropBranchTableIfExists() {
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

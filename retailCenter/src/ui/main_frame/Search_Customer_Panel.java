package ui.main_frame;

import exception.exception;
import model.Customer;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Search_Customer_Panel extends JPanel {
    private int width;
    private int height;
    private JLabel phone_number_label;
    private JTextField phone_number_field;
    private JButton enter_button;
    private Customer customer;
    private RC_Frame rc;
    private JLabel address_label;
    private JButton edit_button;
    private JLabel edit_label;
    private JTextField edit_field;

    public Search_Customer_Panel(int width, int height, RC_Frame rc){
        this.width = width;
        this.height = height;
        this.rc = rc;
        set_panel();
        setup();
        attach_items();
        set_color();
    }

    private void set_color(){
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }

    private void attach_items() {
        this.add(phone_number_label);
        this.add(phone_number_field);
        this.add(enter_button);
        //set bounds
        phone_number_label.setBounds(width/8, 4*height/12, width/5, height/6);
        phone_number_field.setBounds(width/3, 4*height/12, width/3, height/6);
        enter_button.setBounds(2*width/3, 4*height/12, width/8, height/6);
    }

    private void setup(){
        phone_number_label = new JLabel("Enter the phone number:");
        phone_number_field = new JTextField();
        enter_button = new JButton("enter");
        //set font
        phone_number_label.setFont(new Font("Serif", Font.PLAIN, width /60));
        phone_number_field.setFont(new Font("Serif", Font.PLAIN, width /50));
        enter_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        enter_button.setFocusPainted(false);
        enter_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSearchCustomer(e);
            }
        });
    }

    private void set_panel(){
        this.setLayout(null);
    }

    private void setup_edit() {
        this.edit_label = new JLabel("update: ");
        this.address_label = new JLabel(customer.getAddress());
        this.edit_field = new JTextField();
        this.edit_button = new JButton("edit");
        for (JLabel jLabel : Arrays.asList(address_label, edit_label)) {
            jLabel.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        edit_field.setFont(new Font("Serif", Font.PLAIN, width /50));
        edit_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        edit_button.setFocusPainted(false);
    }
    public void handleEditCustomer(ActionEvent evt) {
        try {
            String edit = edit_field.getText();
            rc.start.updateCustomer(customer.getPhoneNumber(),edit, customer.getName());
            JOptionPane.showMessageDialog(null, "Customer information is updated");
        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

    private void attach_edit() {
        this.add(edit_label);
        this.add(address_label);
        this.add(edit_field);
        this.add(edit_button);
        //set bounds
        address_label.setBounds(200, 200, width / 6, height / 10);
        edit_field.setBounds(200, 250, width / 6, height / 10);
        edit_button.setBounds( 200, 300, width / 6, height / 10);
        edit_label.setBounds(100, 250, width / 6, height / 10);

    }
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == enter_button) {
//            String phone_number = phone_number_field.getText();
//            DatabaseHandler dbh = new DatabaseHandler();
//            try {
//                this.customerList = dbh.searchCustomer(phone_number);
//            } catch (exception err) {
//                System.out.println(err.getMessage());
//            }
//        }
//    }

    public void handleSearchCustomer(ActionEvent evt) {
        try {
            String phone_number = phone_number_field.getText();
            this.customer = rc.start.searchCustomer(phone_number);
            JOptionPane.showMessageDialog(null, "Successful");
            setup_edit();
            attach_edit();
            edit_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleEditCustomer(e);
                }
            });

        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }


}


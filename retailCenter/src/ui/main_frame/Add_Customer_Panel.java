package ui.main_frame;

import Controller.Controller;
import Controller.delegates.StartUpDelegate;
import model.Customer;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class Add_Customer_Panel extends JPanel{
    private int width;
    private int height;
    private JLabel name_label;
    private JLabel address_label;
    private JLabel phone_number_label;
    public JTextField name_field;
    public JTextField address_field;
    public JTextField phone_number_field;
    private JButton add_button;

    private String phoneNumber;
    private String name;
    private String address;
    private RC_Frame rc;


    public Add_Customer_Panel(int width, int height, RC_Frame rc){
        this.width = width;
        this.height = height;
        this.rc = rc;
        set_panel();
        setup();
        attach_items();
        set_color();
        this.setVisible(true);

    }

    private void attach_items() {
        this.add(name_label);
        this.add(address_label);
        this.add(phone_number_label);
        this.add(name_field);
        this.add(address_field);
        this.add(phone_number_field);
        this.add(add_button);
        //set bounds
        name_label.setBounds(width/6, height/12, width/6, height/8);
        address_label.setBounds(width/6, 4*height/12, width/6, height/8);
        phone_number_label.setBounds(width/6, 7*height/12, width/6, height/8);
        name_field.setBounds(width/3, height/12, width/3, height/8);
        address_field.setBounds(width/3, 4*height/12, width/3, height/8);
        phone_number_field.setBounds(width/3, 7*height/12, width/3, height/8);
        add_button.setBounds(9*width/12, 7*height/12, width/6, height/8);
    }

    private void setup(){
        name_label = new JLabel("Name:");
        address_label = new JLabel("Address:");
        phone_number_label = new JLabel("Phone Number:");
        name_field = new JTextField();
        address_field = new JTextField();
        phone_number_field = new JTextField();
        add_button = new JButton("confirm");
        //set font
        for (JLabel jLabel : Arrays.asList(name_label, address_label, phone_number_label)) {
            jLabel.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        for (JTextField jTextField : Arrays.asList(name_field, address_field, phone_number_field)) {
            jTextField.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        add_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        add_button.setFocusPainted(false);
        add_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddCustomer(e);
            }
        });
    }

    public void handleAddCustomer(ActionEvent evt) {
        try {
            phoneNumber = phone_number_field.getText();
            name = name_field.getText();
            address = address_field.getText();
            Customer c = new Customer(phoneNumber,name,address);
            rc.start.addCustomer(c);
            JOptionPane.showMessageDialog(null, "Successful");

        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }



    private void set_panel(){
        this.setLayout(null);
    }

    private void set_color(){
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }

}

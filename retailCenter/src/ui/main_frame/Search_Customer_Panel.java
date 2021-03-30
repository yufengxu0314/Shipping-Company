package ui.main_frame;

import database.DatabaseHandler;
import exception.exception;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Search_Customer_Panel extends JPanel implements ActionListener {
    private int width;
    private int height;
    private JLabel phone_number_label;
    private JTextField phone_number_field;
    private JButton enter_button;
    private ArrayList<String> customerList;


    public Search_Customer_Panel(int width, int height){
        this.width = width;
        this.height = height;
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
    }

    private void set_panel(){
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enter_button) {
            String phone_number = phone_number_field.getText();
            DatabaseHandler dbh = new DatabaseHandler();
            try {
                this.customerList = dbh.searchCustomer(phone_number);
            } catch (exception err) {
                System.out.println(err.getMessage());
            }
        }
    }


}


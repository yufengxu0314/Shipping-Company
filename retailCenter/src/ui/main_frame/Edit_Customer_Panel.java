package ui.main_frame;

import model.Customer;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Edit_Customer_Panel extends JPanel {
    private int width;
    private int height;
    private JLabel phone_number_label;
    private JLabel name_label;
    private JLabel address_label;
    private JButton edit_button;
    private Search_Customer_Panel search_customer_panel;
    private RC_Frame rc;
    private JLabel edit_label;
    private JTextField edit_field;
    private Customer customer;

    public Edit_Customer_Panel(int width, int height, RC_Frame rc, Customer customer){
        this.width = width;
        this.height = height;
        this.rc = rc;
        this.customer = customer;
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
        this.add(name_label);
        this.add(address_label);
        //set bounds
        phone_number_label.setBounds(width/8, 4*height/12, width/5, height/6);
        name_label.setBounds(width/8, 4*height/12, width/5, height/6);
        address_label.setBounds(width/8, 4*height/12, width/5, height/6);
        edit_button.setBounds(2*width/3, 4*height/12, width/8, height/6);
    }

    private void set_panel(){
        this.setLayout(null);
    }

    private void setup(){
        phone_number_label = new JLabel(customer.getPhoneNumber());
        name_label = new JLabel(customer.getName());
        address_label = new JLabel(customer.getAddress());
        edit_label = new JLabel("new address:");
        edit_field = new JTextField();
        edit_button = new JButton("edit");
        //set font
        for (JLabel jLabel : Arrays.asList(name_label, address_label, phone_number_label, edit_label)) {
            jLabel.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        edit_field.setFont(new Font("Serif", Font.PLAIN, width /50));
        edit_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        edit_button.setFocusPainted(false);
        edit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEditCustomer(e);
            }
        });
    }

    public void handleEditCustomer(ActionEvent evt) {
        try {
            String edit = edit_field.getText();
            rc.start.updateCustomer(customer.getPhoneNumber(),edit,customer.getName());
            JOptionPane.showMessageDialog(null, "Customer information is updated");
        } catch (Exception exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }


}

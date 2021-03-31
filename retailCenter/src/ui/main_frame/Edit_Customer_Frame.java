package ui.main_frame;

import model.Customer;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Edit_Customer_Frame extends JFrame {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width;
    private int height;
    private RC_Frame rc;
    private JLabel edit_label;
    private JTextField edit_field;
    private JButton edit_button;
    private Customer customer;

    public Edit_Customer_Frame(int width, int height, RC_Frame rc, Customer customer){
        this.width = width;
        this.height = height/2;
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
        edit_label = new JLabel("New Address:");
        edit_field = new JTextField();
        edit_button = new JButton("Confirm");
        //set font
        edit_label.setFont(new Font("Serif", Font.PLAIN, width /50));
        edit_field.setFont(new Font("Serif", Font.PLAIN, width /50));
        edit_button.setFont(new Font("Serif", Font.PLAIN, width /50));

        edit_label.setBounds( 0,height/8, width/5, 3*height/8);
        edit_field.setBounds( width/4,height/8, 3*width/5, 3*height/8);
        edit_button.setBounds( 2*width/5,4*height/8, width/5, 3*height/8);


        edit_button.setFocusPainted(false);
        edit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEditCustomer(e);
            }
        });
    }

    private void set_panel(){
        this.setLayout(null);
    }

    private void setup(){
        this.setBounds(screenSize.width / 4 + this.width / 6, screenSize.height / 6 + this.height / 10, this.width, this.height);
        this.setTitle("Edit Address");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
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

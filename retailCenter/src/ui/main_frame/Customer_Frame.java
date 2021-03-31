package ui.main_frame;

import model.Customer;
import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Customer_Frame extends JFrame implements WindowListener, ActionListener {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width;
    private int height;

    private JLabel name_label;
    private JLabel phone_label;
    private JLabel address_label;
    private JLabel name;
    private JLabel phone;
    private JLabel address;
    private JButton edit_button;
    private JButton finish_button;
    private Font font;
    private Customer customer;
    private RC_Frame rc;


    public Customer_Frame(int width, int height, RC_Frame rc, Customer customer) {
        this.width = 4 * width / 5;
        this.height = height;
        this.customer = customer;
        this.rc = rc;
        this.setBounds(screenSize.width / 5 + this.width / 8, screenSize.height / 5 + this.height / 8, this.width, this.height);
        set_panel();
        attach_items();
        set_color();
    }

    private void attach_items() {
        this.font = new Font("Serif", Font.PLAIN, width / 45);

        this.name_label = new JLabel("Name: ");
        this.phone_label = new JLabel("Phone Number: ");
        this.address_label = new JLabel("Address: ");
        this.name = new JLabel(customer.getName());
        this.phone = new JLabel(customer.getPhoneNumber());
        this.address = new JLabel(customer.getAddress());
        this.edit_button = new JButton("Edit");
        this.finish_button = new JButton("FINISHED");

        this.name_label.setHorizontalAlignment(JButton.RIGHT);
        this.phone_label.setHorizontalAlignment(JButton.RIGHT);
        this.address_label.setHorizontalAlignment(JButton.RIGHT);
        this.name.setHorizontalAlignment(JButton.LEFT);
        this.phone.setHorizontalAlignment(JButton.LEFT);
        this.address.setHorizontalAlignment(JButton.LEFT);

        this.name_label.setFont(font);
        this.phone_label.setFont(font);
        this.address_label.setFont(font);
        this.name.setFont(font);
        this.phone.setFont(font);
        this.address.setFont(font);
        this.edit_button.setFont(font);
        this.finish_button.setFont(font);


        name_label.setBounds(0, height / 9, width / 5, height / 9);
        phone_label.setBounds(0, 3*height / 9, width / 5, height / 9);
        address_label.setBounds(0, 5*height / 9, width / 5, height / 9);
        name.setBounds( width / 4, height / 9, width / 2, height / 9);
        phone.setBounds(width / 4, 3*height / 9, width / 2, height / 9);
        address.setBounds(width / 4, 5*height / 9, width / 2, height / 9);

        edit_button.setBounds(3 * width / 4, 5*height / 9, width / 7, height / 9);
        finish_button.setBounds(2 * width / 5, 7*height / 9, width / 5, height / 9);

        this.add(name_label);
        this.add(phone_label);
        this.add(address_label);
        this.add(name);
        this.add(phone);
        this.add(address);
        this.add(edit_button);
        this.add(finish_button);

        edit_button.addActionListener(this);
    }

    private void set_color() {
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }


    private void set_panel() {
        this.setTitle("Customer Result");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(this);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == edit_button) {
            new Edit_Customer_Frame(width,height,rc, customer);
        }
        if (button == finish_button) {

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

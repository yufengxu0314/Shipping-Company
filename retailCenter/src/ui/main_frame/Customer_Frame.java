package ui.main_frame;

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
    private Font font;


    private ShippingOrder temp_order;

    public Customer_Frame(int width, int height) {
        this.width = 4 * width / 5;
        this.height = height;
        this.setBounds(screenSize.width / 5 + this.width / 8, screenSize.height / 5 + this.height / 8, this.width, this.height);
        set_panel();
        attach_items();
        set_color();
    }

    private void set_top() {
        this.font = new Font("Serif", Font.PLAIN, width / 45);

        this.name_label = new JLabel("Tracking ID");
        this.phone_label = new JLabel("From");
        this.address_label = new JLabel("Sender Phone");
        this.name = new JLabel("Receiver Phone");
        this.phone = new JLabel("To");
        this.address = new JLabel("Status");
        this.edit_button = new JButton("Edit");

        this.name_label.setHorizontalAlignment(JButton.LEFT);
        this.phone_label.setHorizontalAlignment(JButton.LEFT);
        this.address_label.setHorizontalAlignment(JButton.LEFT);
        this.name.setHorizontalAlignment(JButton.RIGHT);
        this.phone.setHorizontalAlignment(JButton.RIGHT);
        this.address.setHorizontalAlignment(JButton.RIGHT);

        this.name_label.setFont(font);
        this.phone_label.setFont(font);
        this.address_label.setFont(font);
        this.name.setFont(font);
        this.phone.setFont(font);
        this.address.setFont(font);
        this.edit_button.setFont(font);


        name_label.setBounds(width / 9, 0, width / 4, height / 9);
        phone_label.setBounds(3 * width / 9, 0, width / 4, height / 9);
        address_label.setBounds(5 * width / 9, 0, width / 4, height / 9);
        name.setBounds( width / 9, width / 4, width / 2, height / 9);
        phone.setBounds(3 * width / 9, width / 4, width / 2, height / 9);
        address.setBounds(5 * width / 9, width / 4, width / 2, height / 9);
        edit_button.setBounds(5 * width / 9, 3*width / 4, width / 2, height / 9);

        this.add(name_label);
        this.add(phone_label);
        this.add(address_label);
        this.add(name);
        this.add(phone);
        this.add(address);
        this.add(edit_button);

    }

    private void set_color() {
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }

    private void attach_items() {
//
//        panel = new Order_List_Panel(width, 7 * height / 8);
//
//        scroll = new JScrollPane(panel);
//        scroll.setBounds(0, height / 10, width, 9 * height / 10);
//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        this.add(scroll);
    }


    private void set_panel() {
        this.setTitle("Order List");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(this);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

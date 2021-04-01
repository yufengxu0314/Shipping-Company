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
import java.util.ArrayList;

public class VIP_Frame extends JFrame implements WindowListener, ActionListener {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width;
    private int height;
    private VIP_Panel panel;
    private JScrollPane scroll;
    private RC_Frame rc;

    private JLabel name;
    private JLabel phone;
    private JLabel address;
    private Font font;
//    private ArrayList<ShippingOrder> orders;


    public VIP_Frame(int width, int height, ArrayList<Customer> customers, RC_Frame rc ) {
        this.width = 4 * width / 5;
        this.height = height;
//        this.orders = orders;
        this.setBounds(screenSize.width / 5 + this.width / 8, screenSize.height / 5 + this.height / 8, this.width, this.height);
        set_top();
        set_panel();
        attach_items();
        set_color();
        this.rc = rc;
        for(Customer customer: customers){
            panel.add_entry(customer);
        }
    }


    private void set_top() {
        this.font = new Font("Serif", Font.PLAIN, width / 45);

        this.name = new JLabel("Name");
        this.phone = new JLabel("Phone");
        this.address = new JLabel("Address");

        this.name.setHorizontalAlignment(JButton.CENTER);
        this.phone.setHorizontalAlignment(JButton.CENTER);
        this.address.setHorizontalAlignment(JButton.CENTER);

        this.name.setFont(font);
        this.phone.setFont(font);
        this.address.setFont(font);


        name.setBounds(0, 0, width / 4, height / 10);
        phone.setBounds(1 * width / 4, 0, width / 4, height / 10);
        address.setBounds(2 * width / 4, 0, width / 2, height / 10);

        this.add(name);
        this.add(phone);
        this.add(address);

    }

    private void set_color() {
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }

    private void attach_items() {

        panel = new VIP_Panel(width, 7 * height / 8, rc);

        scroll = new JScrollPane(panel);
        scroll.setBounds(0, height / 10, width, 9 * height / 10);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);
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

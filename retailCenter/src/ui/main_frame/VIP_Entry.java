package ui.main_frame;

import model.Customer;
import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class VIP_Entry extends JPanel implements ActionListener, FocusListener {
    private int width;
    private int height;
    private Font font;
    private JLabel name;
    private JLabel phone;
    private JLabel address;

    public VIP_Entry (int width, int height, Customer order) {
        this.font = new Font("Serif", Font.PLAIN, width / 45);
        this.width = width;
        this.height = height;
        setup(order);
        set_font();
        set_color(My_Color.RED);
        set_bounds();
        set_panel();
    }



    private void setup(Customer order) {
        this.name = new JLabel(String.valueOf(order.getName()));
        this.phone = new JLabel(order.getPhoneNumber());
        this.address = new JLabel(order.getAddress());

        this.name.setHorizontalAlignment(JButton.CENTER);
        this.phone.setHorizontalAlignment(JButton.CENTER);
        this.address.setHorizontalAlignment(JButton.LEFT);

    }



    private void set_font() {
        this.name.setFont(font);
        this.phone.setFont(font);
        this.address.setFont(font);
    }

    private void set_color(Color color) {
        this.name.setBackground(color);
        this.phone.setBackground(color);
        this.address.setBackground(color);
        this.setBackground(My_Color.PANEL_BACKGROUND);

        set_foreground_color(My_Color.LETTER_GREY);
    }

    private void set_foreground_color(Color color){
        phone.setForeground(color);
        address.setForeground(color);
        name.setForeground(color);
    }


    private void set_bounds() {
        name.setBounds(0, height/10, width / 4, 8*height / 10);
        phone.setBounds(1 * width / 4, height/10, width / 4, 8*height / 10);
        address.setBounds(2 * width / 4, height/10, width / 2, 8*height / 10);

    }

    private void set_panel() {
        this.add(name);
        this.add(phone);
        this.add(address);

        this.setBorder(null);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(width,height));
        this.addFocusListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
//        set_color(My_Color.DARK_GREEN);
//        set_foreground_color(My_Color.WHITE);
//        this.setBackground(My_Color.DARK_GREEN);
    }

    @Override
    public void focusLost(FocusEvent e) {
//        setBackground(My_Color.PANEL_BACKGROUND);
//        set_foreground_color(My_Color.LETTER_GREY);
//        Object o = e.getSource();
    }
}

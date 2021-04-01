package ui.main_frame;

import model.ShippingOrderCombined;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sender_Entry extends JPanel implements ActionListener{
    private int width;
    private int height;
    private Font font;
    private JLabel id;
    private JLabel temp1;
    private JLabel name;
    private JLabel temp2;
    private JLabel phone_number;
    private JButton delete;
    private RC_Frame rc;
    private ShippingOrderCombined order;

    public Sender_Entry (int width, int height, ShippingOrderCombined order, RC_Frame rc) {
        this.font = new Font("Serif", Font.PLAIN, width / 45);
        this.width = width;
        this.height = height;
        this.rc = rc;
        this.order = order;
        setup(order);
        set_font();
        set_color(My_Color.RED);
        set_bounds();
        set_panel();
        set_button();
        delete.addActionListener(this);
    }



    private void setup(ShippingOrderCombined order) {
        this.id = new JLabel(String.valueOf(order.getTrackingID()));
        this.temp1 = new JLabel("");
        this.name = new JLabel(order.getSenderName());
        this.temp2 = new JLabel("");
        this.phone_number = new JLabel(order.getSenderPhoneNumber());
        this.delete = new JButton("Delete");

        this.id.setHorizontalAlignment(JButton.CENTER);
        this.temp1.setHorizontalAlignment(JButton.CENTER);
        this.name.setHorizontalAlignment(JButton.LEFT);
        this.temp2.setHorizontalAlignment(JButton.LEFT);
        this.phone_number.setHorizontalAlignment(JButton.CENTER);
        this.delete.setHorizontalAlignment(JButton.CENTER);

    }

    private void set_button(){
        delete.setBackground(My_Color.RED);
        delete.setBorderPainted(false);
        delete.setForeground(My_Color.WHITE);
        delete.setOpaque(true);
        delete.setFont(new Font("Serif", Font.PLAIN, width /70));
        delete.setFocusPainted(false);
    }


    private void set_font() {
        this.id.setFont(font);
        this.temp1.setFont(font);
        this.name.setFont(font);
        this.temp2.setFont(font);
        this.phone_number.setFont(font);
    }

    private void set_color(Color color) {
        this.id.setBackground(color);
        this.temp1.setBackground(color);
        this.name.setBackground(color);
        this.temp2.setBackground(color);
        this.phone_number.setBackground(color);
        this.setBackground(My_Color.PANEL_BACKGROUND);

        set_foreground_color(My_Color.LETTER_GREY);
    }

    private void set_foreground_color(Color color){
        temp1.setForeground(color);
        name.setForeground(color);
        temp2.setForeground(color);
        phone_number.setForeground(color);
        id.setForeground(color);
    }


    private void set_bounds() {
        id.setBounds(0,height/10,width / 6, 8*height/10);

        temp1.setBounds(1*width / 6,height/10,width /6, 8*height/10);

        name.setBounds(2*width / 6, height/10 , width/ 6, 8*height/10);

        temp2.setBounds(3*width / 6, height/10, width /6, 8*height/10);

        phone_number.setBounds(4*width / 6, height/10, width / 6, 8*height/10);

        delete.setBounds(5*width /6, 2*height/10, width / 8, 6*height/10);
        delete.setVisible(false);

    }

    private void set_panel() {
        this.add(id);
        this.add(temp1);
        this.add(name);
        this.add(temp2);
        this.add(phone_number);
        this.add(delete);

        this.setBorder(null);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(width,height));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == delete) {
//            rc.start.deleteOrder(order.getTrackingID());
            this.setVisible(false);
        }

    }
}

package ui.main_frame;

import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLOutput;

public class Order_Entry extends JPanel implements ActionListener {
    private int width;
    private int height;
    private Font font;
    private JLabel id;
    private JLabel from;
    private JLabel sender;
    private JLabel receiver;
    private JLabel to;
    private JButton delete;
    private RC_Frame rc;
    private ShippingOrder order;

    public Order_Entry (int width, int height, ShippingOrder order, RC_Frame rc2) {
        this.font = new Font("Serif", Font.PLAIN, width / 45);
        this.width = width;
        this.height = height;
        this.rc = rc2;
        this.order = order;
        setup(order);
        set_font();
        set_color(My_Color.RED);
        set_bounds();
        set_panel();
        set_button();
        delete.addActionListener(this);
    }



    private void setup(ShippingOrder order) {
        this.id = new JLabel(String.valueOf(order.getTrackingID()));
        this.from = new JLabel("from");
        this.sender = new JLabel(order.getSender());
        this.receiver = new JLabel(order.getReceiver());
        this.to = new JLabel("to");
        this.delete = new JButton("Delete");

        this.id.setHorizontalAlignment(JButton.CENTER);
        this.from.setHorizontalAlignment(JButton.CENTER);
        this.sender.setHorizontalAlignment(JButton.LEFT);
        this.receiver.setHorizontalAlignment(JButton.LEFT);
        this.to.setHorizontalAlignment(JButton.CENTER);
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
        this.from.setFont(font);
        this.sender.setFont(font);
        this.receiver.setFont(font);
        this.to.setFont(font);
    }

    private void set_color(Color color) {
        this.id.setBackground(color);
        this.from.setBackground(color);
        this.sender.setBackground(color);
        this.receiver.setBackground(color);
        this.to.setBackground(color);
        this.setBackground(My_Color.PANEL_BACKGROUND);

        set_foreground_color(My_Color.LETTER_GREY);
    }

    private void set_foreground_color(Color color){
        from.setForeground(color);
        sender.setForeground(color);
        receiver.setForeground(color);
        to.setForeground(color);
        id.setForeground(color);
    }


    private void set_bounds() {
        id.setBounds(0,height/10,width / 6, 8*height/10);

        from.setBounds(1*width / 6,height/10,width /6, 8*height/10);

        sender.setBounds(2*width / 6, height/10 , width/ 6, 8*height/10);

        receiver.setBounds(3*width / 6, height/10, width /6, 8*height/10);

        to.setBounds(4*width / 6, height/10, width / 6, 8*height/10);

        delete.setBounds(5*width /6, 2*height/10, width / 8, 6*height/10);


    }

    private void set_panel() {
        this.add(id);
        this.add(from);
        this.add(sender);
        this.add(receiver);
        this.add(to);
        this.add(delete);

        this.setBorder(null);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(width,height));
//        this.addFocusListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == delete) {
            try {
                this.setVisible(false);
                rc.start.deleteOrder(order.getTrackingID());
//            System.out.println("successful11111");
            } catch (Exception e2){
                System.out.println("still have unhandled exception");
            }
        }

    }

}

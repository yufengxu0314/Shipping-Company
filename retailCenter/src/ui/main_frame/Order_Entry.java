package ui.main_frame;

import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Order_Entry extends JPanel implements ActionListener, FocusListener {
    private int width;
    private int height;
    private Font font;
    private JLabel id;
    private JLabel from;
    private JLabel sender;
    private JLabel receiver;
    private JLabel to;
    private JLabel status;

    public Order_Entry (int width, int height, ShippingOrder order) {
        this.font = new Font("Serif", Font.PLAIN, width / 45);
        this.width = width;
        this.height = height;

        setup(order);
        set_font();
        set_color(My_Color.RED);
        set_bounds();
        set_panel();
    }



    private void setup(ShippingOrder order) {
        this.id = new JLabel(String.valueOf(order.getTrackingID()));
        this.from = new JLabel("from");
        this.sender = new JLabel(order.getSender());
        this.receiver = new JLabel(order.getReceiver());
        this.to = new JLabel("to");
        this.status = new JLabel(String.format("unknown"));

        this.id.setHorizontalAlignment(JButton.CENTER);
        this.from.setHorizontalAlignment(JButton.CENTER);
        this.sender.setHorizontalAlignment(JButton.LEFT);
        this.receiver.setHorizontalAlignment(JButton.LEFT);
        this.to.setHorizontalAlignment(JButton.CENTER);
        this.status.setHorizontalAlignment(JButton.CENTER);

    }


    private void set_font() {
        this.id.setFont(font);
        this.from.setFont(font);
        this.sender.setFont(font);
        this.receiver.setFont(font);
        this.to.setFont(font);
        this.status.setFont(font);
    }

    private void set_color(Color color) {
        this.id.setBackground(color);
        this.from.setBackground(color);
        this.sender.setBackground(color);
        this.receiver.setBackground(color);
        this.to.setBackground(color);
        this.status.setBackground(color);
        this.setBackground(My_Color.PANEL_BACKGROUND);

        set_foreground_color(My_Color.LETTER_GREY);
    }

    private void set_foreground_color(Color color){
        from.setForeground(color);
        sender.setForeground(color);
        receiver.setForeground(color);
        to.setForeground(color);
        status.setForeground(color);
        id.setForeground(color);
    }


    private void set_bounds() {
        id.setBounds(0,height/10,width / 6, 8*height/10);

        from.setBounds(1*width / 6,height/10,width /6, 8*height/10);

        sender.setBounds(2*width / 6, height/10 , width/ 6, 8*height/10);

        receiver.setBounds(3*width / 6, height/10, width /6, 8*height/10);

        to.setBounds(4*width / 6, height/10, width / 6, 8*height/10);

        status.setBounds(5*width /6, height/10, width / 6, 8*height/10);


    }

    private void set_panel() {
        this.add(id);
        this.add(from);
        this.add(sender);
        this.add(receiver);
        this.add(to);
        this.add(status);

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
        set_color(My_Color.DARK_GREEN);
        set_foreground_color(My_Color.WHITE);
        this.setBackground(My_Color.DARK_GREEN);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBackground(My_Color.PANEL_BACKGROUND);
        set_foreground_color(My_Color.LETTER_GREY);
        Object o = e.getSource();
    }
}

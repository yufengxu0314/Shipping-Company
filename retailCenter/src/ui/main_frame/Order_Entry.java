package ui.main_frame;

import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Order_Entry extends JPanel implements ActionListener, FocusListener {
    private int width;
    private int height;
    private boolean is_focused;
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
        this.is_focused = false;
        //this.font = font;

        setup(order);
        set_font();
        set_color(My_Color.WHITE);
        set_bounds();

        set_panel();
    }

    public void set_line (int line) {
        this.from.setText("" + line);
        reload();
    }


    public boolean selected ()
    {
        return this.is_focused;
    }

    private void reload() {
        this.revalidate();
        this.repaint();
    }

    private void setup(ShippingOrder order) {
        this.id = new JLabel(String.valueOf(order.TrackingID));
        this.from = new JLabel("null");
        this.sender = new JLabel("null");
        this.receiver = new JLabel("null");
        this.to = new JLabel("null");
        this.status = new JLabel(String.format("unknown"));



        this.id.setHorizontalAlignment(JButton.CENTER);
        this.from.setHorizontalAlignment(JButton.CENTER);
        this.sender.setHorizontalAlignment(JButton.LEFT);
        this.receiver.setHorizontalAlignment(JButton.LEFT);
        this.to.setHorizontalAlignment(JButton.LEFT);
        this.status.setHorizontalAlignment(JButton.RIGHT);

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
        id.setBounds(0,height/10,width / 30, 8*height/10);

        from.setBounds(width / 30,height/10,width * 2/30, 8*height/10);

        sender.setBounds(width / 10, height/10 , width * 4/10, 8*height/10);

        receiver.setBounds(width / 2, height/10, width / 12, 8*height/10);

        to.setBounds(width * 5/8, height/10, width / 12, 8*height/10);

        status.setBounds(width * 6/8, height/10, width / 12, 8*height/10);


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
    }

    private void setup_enter(JTextField textField) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        //this.setBorder(BorderFactory.createDashedBorder(Color.black));
        //this.setBorder(BorderFactory.createLineBorder(My_Color.GREEN,5));
        this.is_focused = true;
        this.setBackground(My_Color.DARK_GREEN);
        set_foreground_color(My_Color.WHITE);
    }

    @Override
    public void focusLost(FocusEvent e) {
//        this.setBorder(null);
        this.is_focused = false;
        this.setBackground(My_Color.PANEL_BACKGROUND);
        set_foreground_color(My_Color.LETTER_GREY);
        Object o = e.getSource();
    }
}

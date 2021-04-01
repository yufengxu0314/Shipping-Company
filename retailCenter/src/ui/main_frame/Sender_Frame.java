package ui.main_frame;

import model.ShippingOrder;
import model.ShippingOrderCombined;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Sender_Frame extends JFrame {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width;
    private int height;
    private Sender_Panel panel;
    private JScrollPane scroll;
    private RC_Frame rc;

    private JLabel id;
    private JLabel from;
    private JLabel sender;
    private JLabel receiver;
    private JLabel to;
    private JLabel status;
    private Font font;
//    private ArrayList<ShippingOrder> orders;

//    private ShippingOrder temp_order;

    public Sender_Frame(int width, int height, ArrayList<ShippingOrderCombined> orders, RC_Frame rc ) {
        this.width = 4 * width / 5;
        this.height = height;
//        this.orders = orders;
        this.setBounds(screenSize.width / 5 + this.width / 8, screenSize.height / 5 + this.height / 8, this.width, this.height);
        set_top();
        set_panel();
        attach_items();
        set_color();
        this.rc = rc;
        for(ShippingOrderCombined order: orders){
            panel.add_entry(order);
        }
    }


    private void set_top() {
        this.font = new Font("Serif", Font.PLAIN, width / 45);

        this.id = new JLabel("Tracking ID");
        this.from = new JLabel("From");
        this.sender = new JLabel("Sender Phone");
        this.receiver = new JLabel("Receiver Phone");
        this.to = new JLabel("To");
        this.status = new JLabel("");

        this.id.setHorizontalAlignment(JButton.CENTER);
        this.from.setHorizontalAlignment(JButton.CENTER);
        this.sender.setHorizontalAlignment(JButton.CENTER);
        this.receiver.setHorizontalAlignment(JButton.CENTER);
        this.to.setHorizontalAlignment(JButton.CENTER);
        this.status.setHorizontalAlignment(JButton.CENTER);

        this.id.setFont(font);
        this.from.setFont(font);
        this.sender.setFont(font);
        this.receiver.setFont(font);
        this.to.setFont(font);
        this.status.setFont(font);


        id.setBounds(0, 0, width / 6, height / 10);
        from.setBounds(1 * width / 6, 0, width / 6, height / 10);
        sender.setBounds(2 * width / 6, 0, width / 6, height / 10);
        receiver.setBounds(3 * width / 6, 0, width / 6, height / 10);
        to.setBounds(4 * width / 6, 0, width / 6, height / 10);
        status.setBounds(5 * width / 6, 0, width / 6, height / 10);

        this.add(id);
        this.add(from);
        this.add(sender);
        this.add(receiver);
        this.add(to);
        this.add(status);

    }

    private void set_color() {
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }

    private void attach_items() {

        panel = new Sender_Panel(width, 7 * height / 8, rc);

        scroll = new JScrollPane(panel);
        scroll.setBounds(0, height / 10, width, 9 * height / 10);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);
    }


    private void set_panel() {
        this.setTitle("Order List");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        this.addWindowListener(this);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }


}
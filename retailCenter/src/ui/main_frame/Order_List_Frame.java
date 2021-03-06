package ui.main_frame;

import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Order_List_Frame extends JFrame implements WindowListener, ActionListener {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width;
    private int height;
//    private Order_List_Panel panel;
//    private JScrollPane scroll;
//    private RC_Frame rc;

    private JLabel id;
    private JLabel from;
    private JLabel sender;
    private JLabel receiver;
    private JLabel to;
    private JLabel status;
    private Font font;
//    private ArrayList<ShippingOrder> orders;

//    private ShippingOrder temp_order;

    public Order_List_Frame(int width, int height, ArrayList<ShippingOrder> orders, RC_Frame rc ) {
        this.width = 4 * width / 5;
        this.height = height;
//        this.orders = orders;
        this.setBounds(screenSize.width / 5 + this.width / 8, screenSize.height / 5 + this.height / 8, this.width, this.height);
        set_top();
        set_panel();
//        this.rc = rc;
        attach_items(orders, rc);
        set_color();


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

    private void attach_items(ArrayList<ShippingOrder> orders, RC_Frame rc) {

        Order_List_Panel panel = new Order_List_Panel(width, 7 * height / 8, rc);

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(0, height / 10, width, 9 * height / 10);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);
        for(ShippingOrder order: orders){
            panel.add_entry(order);
        }
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
//    private void test(){
//        this.temp_order = new ShippingOrder(12345667, "type", "2019", 12, "szie", "fly", 500);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//        panel.add_entry(temp_order);
//
//
//
//    }
//}
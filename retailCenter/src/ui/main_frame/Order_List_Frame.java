package ui.main_frame;

import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Order_List_Frame extends JFrame implements WindowListener, ActionListener {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width;
    private int height;
    private Order_List_Panel field;

    private ShippingOrder temp_order;

    public Order_List_Frame(int width, int height){
        this.temp_order = new ShippingOrder(12345667, "type", "2019", 12, "szie", "fly", 500);
        this.width = width;
        this.height = height;
        set_panel();
        setup();
        attach_items();
        set_color();
        field.add_entry(temp_order);
    }

    private void set_color(){
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }

    private void attach_items() {

    }

    private void setup(){
        field = new Order_List_Panel(7*width/8, 7*height/8);
        this.setBounds(screenSize.width / 5 + width/8, screenSize.height / 5 + height/8,width,height);
        this.add(field);
    }

    private void set_panel(){
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
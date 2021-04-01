package ui.main_frame;

import model.ShippingOrder;
import model.ShippingOrderCombined;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Search_Order_Panel extends JPanel implements ActionListener{
    private int width;
    private int height;
    private JLabel id_label;
    private JLabel created_after_label;
    private JLabel year_label;
    private JLabel month_label;
    private JLabel day_label;
    private JTextField id_field;
    private JTextField year_field;
    private JTextField month_field;
    private JTextField day_field;
    private JButton search_button;
    private JButton equal_button;
    private JButton after_button;
    private RC_Frame rc;
    private ArrayList<ShippingOrder> orders ;



    public Search_Order_Panel(int width, int height, RC_Frame rc){
        this.width = width;
        this.height = height;
        this.rc = rc;
        set_panel();
        setup();
        attach_items();
        set_color();
    }

    private void set_color(){
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }

    private void attach_items() {
        for (JLabel jLabel : Arrays.asList(id_label, created_after_label, year_label, month_label, day_label)) {
            this.add(jLabel);
        }
        for (JTextField jTextField : Arrays.asList(id_field, year_field, month_field, day_field)) {
            this.add(jTextField);
        }
        this.add(search_button);
        this.add(equal_button);
        this.add(after_button);

        //set bounds
        id_label.setBounds(width/6, height/8, width/4, height/8);
        id_field.setBounds(2*width/6, height/8, width/3, height/8);
        search_button.setBounds(9*width/12, height/8, width/6, height/8);

        created_after_label.setBounds(width/14, 2*height/5, 2*width/13, height/8);

        year_label.setBounds(4*width/14, 2*height/5, width/13, height/8);
        year_field.setBounds(5*width/14, 2*height/5, width/13, height/8);

        month_label.setBounds(7*width/14, 2*height/5, width/13, height/8);
        month_field.setBounds(8*width/14, 2*height/5, width/13, height/8);

        day_label.setBounds(10*width/14, 2*height/5, width/13, height/8);
        day_field.setBounds(11*width/14, 2*height/5, width/13, height/8);


        equal_button.setBounds(width/3, 3*height/5, width/6, height/8);
        after_button.setBounds(2*width/3, 3*height/5, width/6, height/8);
    }

    private void setup(){
        orders = new ArrayList<>();
        id_label = new JLabel("Enter Tracking ID:");
        created_after_label = new JLabel("By Date:");
        year_label = new JLabel("Year:");
        month_label = new JLabel("Month:");
        day_label = new JLabel("Day:");
        id_field = new JTextField();
        year_field = new JTextField();
        month_field = new JTextField();
        day_field = new JTextField();

        search_button = new JButton("By ID");
        equal_button = new JButton("Equal");
        after_button = new JButton("After");

        //set font
        for (JLabel jLabel : Arrays.asList(id_label, created_after_label, year_label, month_label, day_label)) {
            jLabel.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        for (JTextField jTextField : Arrays.asList(id_field, year_field, month_field, day_field)) {
            jTextField.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        search_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        search_button.setFocusPainted(false);
        search_button.addActionListener(this);
        equal_button.addActionListener(this);
        after_button.addActionListener(this);

    }

    private void set_panel(){
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == search_button) {
            try {
                orders.clear();
                int trackingID = Integer.parseInt(id_field.getText());
                ShippingOrder shippingOrder = rc.start.searchTracking(trackingID);
                orders.add(shippingOrder);
                new Order_List_Frame(width, height, orders, rc);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
        else if(button == equal_button){
            try {
                orders.clear();
                String date = year_field.getText() + "/" + month_field.getText() + "/" + day_field.getText();
                ArrayList<ShippingOrderCombined> result = rc.start.findSender(date);
                new Sender_Frame(width, height, result, rc);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error");
            }
        }
        else if(button == after_button){
            try {
                orders.clear();
                String date = year_field.getText() + "/" + month_field.getText() + "/" + day_field.getText();
                ArrayList<String> ids = rc.start.getCreateAfter(date);
                for (int i = 0; i < ids.size(); i++) {
                    orders.add(rc.start.searchTracking(Integer.parseInt(ids.get(i))));
                }
                new Order_List_Frame(width, height, orders, rc);
            } catch (Exception exception) {
                exception.printStackTrace();
                JOptionPane.showMessageDialog(null,"Error");
            }
        }

    }



}
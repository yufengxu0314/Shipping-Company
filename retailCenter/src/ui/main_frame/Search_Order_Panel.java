package ui.main_frame;

import database.databaseHandler;
import exception.exception;
import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Search_Order_Panel extends JPanel implements ActionListener {
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


    public Search_Order_Panel(int width, int height){
        this.width = width;
        this.height = height;
//        this.setBounds(x,y,width,height);
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

        //set bounds
        id_label.setBounds(width/6, height/8, width/4, height/8);
        id_field.setBounds(2*width/6, height/8, width/3, height/8);


        created_after_label.setBounds(width/14, 2*height/5, 2*width/13, height/8);

        year_label.setBounds(4*width/14, 2*height/5, width/13, height/8);
        year_field.setBounds(5*width/14, 2*height/5, width/13, height/8);

        month_label.setBounds(7*width/14, 2*height/5, width/13, height/8);
        month_field.setBounds(8*width/14, 2*height/5, width/13, height/8);

        day_label.setBounds(10*width/14, 2*height/5, width/13, height/8);
        day_field.setBounds(11*width/14, 2*height/5, width/13, height/8);

        search_button.setBounds(5*width/12, 3*height/5, width/6, height/8);
    }

    private void setup(){
        id_label = new JLabel("Enter Tracking ID:");
        created_after_label = new JLabel("Created After:");
        year_label = new JLabel("Year:");
        month_label = new JLabel("Month:");
        day_label = new JLabel("Day:");
        id_field = new JTextField();
        year_field = new JTextField();
        month_field = new JTextField();
        day_field = new JTextField();

        search_button = new JButton("confirm");
        //set font
        for (JLabel jLabel : Arrays.asList(id_label, created_after_label, year_label, month_label, day_label)) {
            jLabel.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        for (JTextField jTextField : Arrays.asList(id_field, year_field, month_field, day_field)) {
            jTextField.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        search_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        search_button.setFocusPainted(false);
    }

    private void set_panel(){
        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search_button) {
            int trackingID = Integer.parseInt(id_field.getText());
            String day = day_field.getText();
            String month = month_field.getText();
            String year = year_field.getText();
            databaseHandler dbh = new databaseHandler();
            try {
                ShippingOrder order = dbh.searchTracking(trackingID);
            } catch (exception err) {
                System.out.println(err.getMessage());
            }
        }
    }

}
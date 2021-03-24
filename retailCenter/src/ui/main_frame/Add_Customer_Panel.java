package ui.main_frame;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Add_Customer_Panel extends JPanel{
    private int width;
    private int height;
    private JLabel name_label;
    private JLabel address_label;
    private JLabel phone_number_label;
    private JTextField name_field;
    private JTextField address_field;
    private JTextField phone_number_field;
    private JButton add_button;


    public Add_Customer_Panel(int width, int height){
        this.width = width;
        this.height = height;
//        this.setBounds(x,y,width,height);
        set_panel();
        setup();
        attach_items();
    }

    private void attach_items() {
        this.add(name_label);
        this.add(address_label);
        this.add(phone_number_label);
        this.add(name_field);
        this.add(address_field);
        this.add(phone_number_field);
        this.add(add_button);
        //set bounds
        name_label.setBounds(width/6, height/12, width/6, height/6);
        address_label.setBounds(width/6, 4*height/12, width/6, height/6);
        phone_number_label.setBounds(width/6, 7*height/12, width/6, height/6);
        name_field.setBounds(width/3, height/12, width/3, height/6);
        address_field.setBounds(width/3, 4*height/12, width/3, height/6);
        phone_number_field.setBounds(width/3, 7*height/12, width/3, height/6);
        add_button.setBounds(9*width/12, 8*height/12, width/6, height/6);
    }

    private void setup(){
        name_label = new JLabel("Name:");
        address_label = new JLabel("Address:");
        phone_number_label = new JLabel("Phone Number:");
        name_field = new JTextField();
        address_field = new JTextField();
        phone_number_field = new JTextField();
        add_button = new JButton("confirm");
        //set font
        for (JLabel jLabel : Arrays.asList(name_label, address_label, phone_number_label)) {
            jLabel.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        for (JTextField jTextField : Arrays.asList(name_field, address_field, phone_number_field)) {
            jTextField.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        add_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        add_button.setFocusPainted(false);
    }

    private void set_panel(){
        this.setLayout(null);
    }

}

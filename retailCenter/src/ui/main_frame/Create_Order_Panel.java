package ui.main_frame;

import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Create_Order_Panel extends JPanel {
    private int width;
    private int height;
    private JLabel type_label;
    private JLabel weight_label;
    private JLabel sender_phone_label;
    private JLabel method_label;
    private JLabel size_label;
    private JLabel receiver_phone_label;
    private JTextField type_field;
    private JTextField weight_field;
    private JTextField sender_phone_field;
    private JTextField method_field;
    private JTextField size_field;
    private JTextField receiver_phone_field;
    private JButton confirm_button;


    public Create_Order_Panel(int width, int height){
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
        for (JLabel jLabel : Arrays.asList(type_label, weight_label, sender_phone_label, method_label, size_label, receiver_phone_label)) {
            this.add(jLabel);
        }
        for (JTextField jTextField : Arrays.asList(type_field, weight_field, sender_phone_field, method_field, size_field, receiver_phone_field)) {
            this.add(jTextField);
        }
        this.add(confirm_button);

        //set bounds
        // first column
        type_label.setBounds(width/12, height/12, width/8, height/8);
        weight_label.setBounds(width/12, 4*height/12, width/8, height/8);
        sender_phone_label.setBounds(width/12, 7*height/12, width/8, height/8);

        type_field.setBounds(width/4, height/12, width/6, height/8);
        weight_field.setBounds(width/4, 4*height/12, width/6, height/8);
        sender_phone_field.setBounds(width/4, 7*height/12, width/6, height/8);
        // second column
        method_label.setBounds(11*width/24, height/12, width/8, height/8);
        size_label.setBounds(11*width/24, 4*height/12, width/8, height/8);
        receiver_phone_label.setBounds(11*width/24, 7*height/12, width/7, height/8);

        method_field.setBounds(15*width/24, height/12, width/6, height/8);
        size_field.setBounds(15*width/24, 4*height/12, width/6, height/8);
        receiver_phone_field.setBounds(15 *width/24, 7*height/12, width/6, height/8);


        confirm_button.setBounds(10*width/12, 7*height/12, width/8, height/8);
    }

    private void setup(){
        type_label = new JLabel("Type:");
        weight_label = new JLabel("Weight:");
        sender_phone_label = new JLabel("Sender Phone:");
        method_label = new JLabel("Method:");
        size_label = new JLabel("Size:");
        receiver_phone_label = new JLabel("Receiver Phone:");
        type_field = new JTextField();
        weight_field = new JTextField();
        sender_phone_field = new JTextField();
        method_field = new JTextField();
        size_field = new JTextField();
        receiver_phone_field = new JTextField();

        confirm_button = new JButton("confirm");
        //set font
        for (JLabel jLabel : Arrays.asList(type_label, weight_label, sender_phone_label, method_label, size_label, receiver_phone_label)) {
            jLabel.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        for (JTextField jTextField : Arrays.asList(type_field, weight_field, sender_phone_field, method_field, size_field, receiver_phone_field)) {
            jTextField.setFont(new Font("Serif", Font.PLAIN, width /50));
        }
        confirm_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        confirm_button.setFocusPainted(false);
    }

    private void set_panel(){
        this.setLayout(null);
    }

}

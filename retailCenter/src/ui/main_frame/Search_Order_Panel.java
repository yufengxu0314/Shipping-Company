package ui.main_frame;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Search_Order_Panel extends JPanel {
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
        id_label.setBounds(width/6, height/8, width/4, height/6);
        id_field.setBounds(2*width/6, height/8, width/3, height/6);


        created_after_label.setBounds(width/14, 2*height/5, 2*width/13, height/6);

        year_label.setBounds(4*width/14, 2*height/5, width/13, height/6);
        year_field.setBounds(5*width/14, 2*height/5, width/13, height/6);

        month_label.setBounds(7*width/14, 2*height/5, width/13, height/6);
        month_field.setBounds(8*width/14, 2*height/5, width/13, height/6);

        day_label.setBounds(10*width/14, 2*height/5, width/13, height/6);
        day_field.setBounds(11*width/14, 2*height/5, width/13, height/6);

        search_button.setBounds(5*width/12, 3*height/5, width/6, height/6);
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

}
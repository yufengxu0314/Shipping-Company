package ui.main_frame;

import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Order_List_Panel extends JPanel {
    private int width;
    private int height;
    private Order_List_Field field;


    public Order_List_Panel(int width, int height){
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

    }

    private void setup(){
        field = new Order_List_Field(width, height);
    }

    private void set_panel(){
        this.setLayout(null);
    }

}
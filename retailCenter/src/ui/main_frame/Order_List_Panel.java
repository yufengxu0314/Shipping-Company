package ui.main_frame;

import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Order_List_Panel extends JPanel {
//    private Order_List_Field sale_panel;
    public final int ENTRIES_PER_VIEW = 10;
    private int width;
    private int height;
    private SpringLayout layout;
    private ArrayList<Order_Entry> entries;
    private ArrayList<ShippingOrder> orders;

    public Order_List_Panel(int width, int height) {
        super(new SpringLayout());
        this.layout = (SpringLayout) this.getLayout();
        this.width = width;
        this.height = height;
        this.entries = new ArrayList<>();
        set_preferred_size(0);

        set_font();
        set_color();
        set_bounds();

        set_scroll_plane();
    }

    private void set_preferred_size(int length) {
        if (length < ENTRIES_PER_VIEW - 1) {
            length = ENTRIES_PER_VIEW - 1;
        }
        this.setPreferredSize(new Dimension(width,height * length / ENTRIES_PER_VIEW));
    }



    public void add_entry (ShippingOrder order) {
        Order_Entry entry = new Order_Entry(width, height/10,order);
        entries.add(entry);
        this.add(entry);
        this.layout.putConstraint(SpringLayout.NORTH,entry,height * (entries.size() - 1)/ENTRIES_PER_VIEW,SpringLayout.NORTH,this);
        set_preferred_size(entries.size());
        reload();
    }



    private void reload() {
        this.revalidate();
        this.repaint();
    }


    private void set_font() {

    }

    private void set_color() {
        this.setBackground(My_Color.PANEL_BACKGROUND);
    }

    private void set_bounds() {
    }

    private void set_scroll_plane() {
        this.setVisible(true);
    }

}


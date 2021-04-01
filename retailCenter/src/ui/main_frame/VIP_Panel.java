package ui.main_frame;

import model.Customer;
import model.ShippingOrder;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VIP_Panel extends JPanel {
    //    private Order_List_Field sale_panel;
    public final int ENTRIES_PER_VIEW = 10;
    private int width;
    private int height;
    private SpringLayout layout;
    private ArrayList<VIP_Entry> entries;
//    private ArrayList<ShippingOrder> orders;

    public VIP_Panel(int width, int height, RC_Frame rc) {
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



    public void add_entry (Customer order) {
        VIP_Entry entry = new VIP_Entry(width, height/10,order);
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


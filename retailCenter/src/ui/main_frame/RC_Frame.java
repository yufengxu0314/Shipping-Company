package ui.main_frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class RC_Frame extends JFrame implements WindowListener, ActionListener {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width;
    private int height;
    private JButton add_customer_button;
    private JButton search_customer_button;
    private JButton create_order_button;
    private JButton search_order_button;
    //panels
    private JPanel add_customer_panel;
    private JPanel search_customer_panel;
    private JPanel create_order_panel;
    private JPanel search_order_panel;


    public RC_Frame(){
        this.width = screenSize.width * 3/5;
        this.height = screenSize.height * 3/5;
        setup();
        attach_items();
        set_frame();
    }

    private void attach_items() {
        this.add(add_customer_button);
        add_customer_button.setBounds(width/13, height/20, 2*width/13, 5* height/40 );
        this.add(search_customer_button);
        search_customer_button.setBounds(4*width/13, height/20, 2*width/13, 5* height/40 );
        this.add(create_order_button);
        create_order_button.setBounds(7*width/13, height/20, 2*width/13, 5* height/40 );
        this.add(search_order_button);
        search_order_button.setBounds(10*width/13, height/20, 2*width/13, 5* height/40 );
        //attach panels
        this.add(add_customer_panel);
        this.add(search_customer_panel);
        this.add(create_order_panel);
        this.add(search_order_panel);
        add_customer_panel.setBounds(0, height/4, width, 3* height/4 );
        search_customer_panel.setBounds(0, height/4, width, 3* height/4 );
        create_order_panel.setBounds(0, height/4, width, 3* height/4 );
        search_order_panel.setBounds(0, height/4, width, 3* height/4 );
        add_customer_panel.setVisible(false);
        search_customer_panel.setVisible(false);
        create_order_panel.setVisible(false);
        search_order_panel.setVisible(false);
        // add action listener
        add_customer_button.addActionListener(this);
        search_customer_button.addActionListener(this);
        create_order_button.addActionListener(this);
        search_order_button.addActionListener(this);
    }

    private void setup() {
        add_customer_button = new JButton("add customer");
        search_customer_button = new JButton("search customer");
        create_order_button = new JButton("create order");
        search_order_button = new JButton("search order");
        // set font
        add_customer_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        search_customer_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        create_order_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        search_order_button.setFont(new Font("Serif", Font.PLAIN, width /50));
        // cancel the focus
        add_customer_button.setFocusPainted(false);
        search_customer_button.setFocusPainted(false);
        create_order_button.setFocusPainted(false);
        search_order_button.setFocusPainted(false);

        //create panels
        add_customer_panel = new Add_Customer_Panel( width, 3*height/4);
        search_customer_panel = new Search_Customer_Panel( width, 3*height/4);
        create_order_panel = new Create_Order_Panel( width, 3*height/4);
        search_order_panel = new Search_Order_Panel( width, 3*height/4);
    }


    private void set_frame() {
        this.setTitle("Retail Center");
        this.setBounds(screenSize.width / 5, screenSize.height / 5,width,height);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(this);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
//        this.is_focused = true;
        if (button == add_customer_button) {
            search_customer_panel.setVisible(false);
            create_order_panel.setVisible(false);
            search_order_panel.setVisible(false);
            add_customer_panel.setVisible(true);
        }
        if (button == search_customer_button) {
            add_customer_panel.setVisible(false);
            create_order_panel.setVisible(false);
            search_order_panel.setVisible(false);
            search_customer_panel.setVisible(true);
        }
        if (button == create_order_button) {
            search_order_panel.setVisible(false);
            add_customer_panel.setVisible(false);
            search_customer_panel.setVisible(false);
            create_order_panel.setVisible(true);
        }
        if (button == search_order_button) {
            add_customer_panel.setVisible(false);
            search_customer_panel.setVisible(false);
            create_order_panel.setVisible(false);
            search_order_panel.setVisible(true);
        }

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

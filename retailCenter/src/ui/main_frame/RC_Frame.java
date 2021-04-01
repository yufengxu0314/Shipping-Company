package ui.main_frame;

import Controller.delegates.StartUpDelegate;
import model.Customer;
import utility.My_Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


public class RC_Frame extends JFrame implements WindowListener, ActionListener {
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width;
    private int height;
    private JButton add_customer_button;
    private JButton search_customer_button;
    private JButton create_order_button;
    private JButton search_order_button;
    private JButton home_button;

    private JButton order_count;
    private JButton All_Method_customer;
    private JButton VIP_customer;
    //panels
    private JPanel add_customer_panel;
    private JPanel search_customer_panel;
    private JPanel create_order_panel;
    private JPanel search_order_panel;
    public StartUpDelegate start = null;


    public RC_Frame(){
        this.width = screenSize.width * 3/5;
        this.height = screenSize.height * 3/5;
        setup();
        attach_items();
        set_frame();
        set_color();
    }

    public void setupDatabase(StartUpDelegate start) {
        this.start = start;
    }


    private void set_color(){
        this.setBackground(My_Color.MAIN_FRAME_GREY);
        for (JButton button: Arrays.asList(add_customer_button, search_customer_button,create_order_button,search_order_button, order_count, All_Method_customer,home_button)){
            button.setBackground(My_Color.GREEN);
            button.setBorderPainted(false);
            button.setForeground(My_Color.WHITE);
            button.setOpaque(true);
            button.setFont(new Font("Serif", Font.PLAIN, width /70));
            button.setFocusPainted(false);
        }
        home_button.setBackground(My_Color.VIP_GREEN);
        order_count.setBackground(My_Color.ALI_BLUE);
        All_Method_customer.setBackground(My_Color.ALI_BLUE);
        VIP_customer.setBackground(My_Color.ALI_BLUE);
    }

    private void attach_items() {
        this.add(home_button);
        home_button.setBounds(width/16, height/20, 2*width/15, 5* height/40 );
        this.add(add_customer_button);
        add_customer_button.setBounds(4*width/16, height/20, 2*width/15, 5* height/40 );
        this.add(search_customer_button);
        search_customer_button.setBounds(7*width/16, height/20, 2*width/15, 5* height/40 );
        this.add(create_order_button);
        create_order_button.setBounds(10*width/16, height/20, 2*width/15, 5* height/40 );
        this.add(search_order_button);
        search_order_button.setBounds(13*width/16, height/20, 2*width/15, 5* height/40 );
        this.add(order_count);
        order_count.setBounds(1*width/15, 16*height/20, 4*width/15, 5* height/40 );
        this.add(All_Method_customer);
        All_Method_customer.setBounds(5*width/15, 16*height/20, 4*width/15, 5* height/40 );
        this.add(VIP_customer);
        VIP_customer.setBounds(9*width/15, 16*height/20, 4*width/15, 5* height/40 );
        //attach panels
        this.add(add_customer_panel);
        this.add(search_customer_panel);
        this.add(create_order_panel);
        this.add(search_order_panel);
        add_customer_panel.setBounds(width/40, height/4, 38*width/40, 3* height/4 );
        search_customer_panel.setBounds(width/40, height/4, 38*width/40, 3* height/4 );
        create_order_panel.setBounds(width/40, height/4, 38*width/40, 3* height/4 );
        search_order_panel.setBounds(width/40, height/4, 38*width/40, 3* height/4 );
        add_customer_panel.setVisible(false);
        search_customer_panel.setVisible(false);
        create_order_panel.setVisible(false);
        search_order_panel.setVisible(false);
        // add action listener
        add_customer_button.addActionListener(this);
        search_customer_button.addActionListener(this);
        create_order_button.addActionListener(this);
        search_order_button.addActionListener(this);
        home_button.addActionListener(this);
        order_count.addActionListener(this);
        All_Method_customer.addActionListener(this);
        VIP_customer.addActionListener(this);
    }



    private void setup() {
        home_button = new JButton("Home");
        add_customer_button = new JButton("Add Customer");
        search_customer_button = new JButton("Search Customer");
        create_order_button = new JButton("Create Order");
        search_order_button = new JButton("Search Order");

        order_count = new JButton("Show Today's Order Count");
        All_Method_customer = new JButton("Show All Methods Customers");
        VIP_customer = new JButton("Show Loyalty Customers");

        //create panels
        add_customer_panel = new Add_Customer_Panel( width, 3*height/4, this);
        search_customer_panel = new Search_Customer_Panel( width, 3*height/4, this);
        create_order_panel = new Create_Order_Panel( width, 3*height/4, this);
        search_order_panel = new Search_Order_Panel( width, 3*height/4, this);
    }


    public void set_frame() {
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
        if (button == add_customer_button) {
            search_customer_panel.setVisible(false);
            create_order_panel.setVisible(false);
            search_order_panel.setVisible(false);
            add_customer_panel.setVisible(true);
            home_button.setBackground(My_Color.GREEN);
            search_customer_button.setBackground(My_Color.GREEN);
            create_order_button.setBackground(My_Color.GREEN);
            search_order_button.setBackground(My_Color.GREEN);
            add_customer_button.setBackground(My_Color.VIP_GREEN);
            order_count.setVisible(false);
            All_Method_customer.setVisible(false);
            VIP_customer.setVisible(false);
        }
        else if (button == search_customer_button) {
            add_customer_panel.setVisible(false);
            create_order_panel.setVisible(false);
            search_order_panel.setVisible(false);
            search_customer_panel.setVisible(true);
            home_button.setBackground(My_Color.GREEN);
            add_customer_button.setBackground(My_Color.GREEN);
            create_order_button.setBackground(My_Color.GREEN);
            search_order_button.setBackground(My_Color.GREEN);
            search_customer_button.setBackground(My_Color.VIP_GREEN);
            order_count.setVisible(false);
            All_Method_customer.setVisible(false);
            VIP_customer.setVisible(false);
        }
        else if (button == create_order_button) {
            search_order_panel.setVisible(false);
            add_customer_panel.setVisible(false);
            search_customer_panel.setVisible(false);
            create_order_panel.setVisible(true);
            home_button.setBackground(My_Color.GREEN);
            add_customer_button.setBackground(My_Color.GREEN);
            search_customer_button.setBackground(My_Color.GREEN);
            search_order_button.setBackground(My_Color.GREEN);
            create_order_button.setBackground(My_Color.VIP_GREEN);
            order_count.setVisible(false);
            All_Method_customer.setVisible(false);
            VIP_customer.setVisible(false);
        }
        else if (button == search_order_button) {
            add_customer_panel.setVisible(false);
            search_customer_panel.setVisible(false);
            create_order_panel.setVisible(false);
            search_order_panel.setVisible(true);
            home_button.setBackground(My_Color.GREEN);
            add_customer_button.setBackground(My_Color.GREEN);
            add_customer_button.setBackground(My_Color.GREEN);
            create_order_button.setBackground(My_Color.GREEN);
            search_order_button.setBackground(My_Color.VIP_GREEN);
            order_count.setVisible(false);
            All_Method_customer.setVisible(false);
            VIP_customer.setVisible(false);
        }
        else if (button == home_button){
            add_customer_panel.setVisible(false);
            search_customer_panel.setVisible(false);
            create_order_panel.setVisible(false);
            search_order_panel.setVisible(false);
            home_button.setBackground(My_Color.VIP_GREEN);
            add_customer_button.setBackground(My_Color.GREEN);
            add_customer_button.setBackground(My_Color.GREEN);
            create_order_button.setBackground(My_Color.GREEN);
            search_order_button.setBackground(My_Color.GREEN);
            order_count.setVisible(true);
            All_Method_customer.setVisible(true);
            VIP_customer.setVisible(true);
        }
        else if (button == All_Method_customer) {
            ArrayList<String> result = start.getLoyaltyCustomer();
//            String ret = "";
//            for (int i = 0; i < result.size(); i++) {
//                ret += result.get(i);
//            }
//            JOptionPane.showMessageDialog(null, ret);
            ArrayList<Customer> customers = new ArrayList<>();
            for(String s: result){
                customers.add(start.searchCustomer(s));
            }
            new VIP_Frame(width,height,customers,this);
        }
        else if (button == VIP_customer) {
            ArrayList<Customer> result = start.findMoreThan();
            new VIP_Frame(width,height,result,this);
        }
        else if (button == order_count) {
            JOptionPane.showMessageDialog(null, start.getDailyCount(getDate()));
        }



    }

    private String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
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

package ledger;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class details implements ActionListener 
{
    JFrame frame;
    JLabel l1,l2;
    JButton b1,b2,b3,b4;
    
    details()
    {
        frame =new JFrame("Ledger");
        frame .setBackground(Color.white);
        frame.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        frame.add(l1);

        l2 = new JLabel("Accounts Detail");
        l2.setBounds(430,20,200,40);
        l2.setFont(new Font("serif",Font.BOLD,25));
        l2.setForeground(Color.black);
        l1.add(l2);

        b1 = new JButton("Add");
        b1.setBounds(420,80,100,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);

        b2=new JButton("View All");
        b2.setBounds(530,80,100,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove");
        b3.setBounds(420,140,100,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update");
        b4.setBounds(530,140,100,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);

        frame.setVisible(true);
        frame.setSize(700,500);
        frame.setLocation(450,200);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            frame.setVisible(false);
            new Add_Bill();
        }
        if(ae.getSource()==b2)
        {
            frame.setVisible(false);
            View_Bill v = new View_Bill();
        }
        if(ae.getSource()==b3)
        {
            frame.setVisible(false);
            new Remove_Bill();
        }
        if(ae.getSource()==b4)
        {
            frame.setVisible(false);
            new Search_Bill();
        }
    }

    public static void main(String[] arg)
    {
        details d = new details();
    }
    
}


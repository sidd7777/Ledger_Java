package ledger;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Remove_Bill implements ActionListener
{
    JFrame f;
    JTextField t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b,b1,b2,b3;

    Remove_Bill()
    {
        f=new JFrame("Remove Bill");
        f.setBackground(Color.green);  
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,500);
        l5.setLayout(null);
        f.add(l5);

       
        l1=new JLabel("Invoice Number:");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.black);
        Font f2 = new Font("serif",Font.BOLD,25);
        l1.setFont(f2);
        l5.add(l1);

        t=new JTextField();
        t.setBounds(250,50,150,30);
        l5.add(t);


        b=new JButton("Search");
        b.setBounds(200,100,100,30);
        b.addActionListener(this);
        l5.add(b);

        b3=new JButton("Back");
        b3.setBounds(360,100,100,30);  
        b3.addActionListener(this);
        l5.add(b3);


        l2=new JLabel("Company Name:");
        l2.setBounds(50,150,250,30);
        l2.setForeground(Color.black);
        Font f3 = new Font("serif",Font.BOLD,20);
        l2.setFont(f3);
        l5.add(l2);

        l6=new JLabel();   
        l6.setBounds(200,150,350,30);
        l6.setForeground(Color.black);
        Font F6=new Font("serif",Font.BOLD,20);
        l6.setFont(F6);
        l5.add(l6);

        l3=new JLabel("Invoice Date:");
        l3.setBounds(50,200,250,30);
        l3.setForeground(Color.black);
        Font f4 = new Font("serif",Font.BOLD,20);
        l3.setFont(f4);
        l5.add(l3);


        l7=new JLabel();
        l7.setBounds(200,200,350,30);
        l7.setForeground(Color.black);
        Font F7=new Font("serif",Font.BOLD,20);
        l7.setFont(F7);
        l5.add(l7);



        l4=new JLabel("Amount:");
        l4.setBounds(50,250,250,30);
        l4.setForeground(Color.black);
        Font F5=new Font("serif",Font.BOLD,20);
        l4.setFont(F5);
        l5.add(l4);

        l8=new JLabel();
        l8.setBounds(200,250,350,30);
        l8.setForeground(Color.black);
        Font f8=new Font("serif",Font.BOLD,20);
        l8.setFont(f8);
        l5.add(l8);

        b1=new JButton("Remove");
        b1.setBounds(120,300,100,30);
        b1.addActionListener(this);
        l5.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(300,300,100,30);
        b2.addActionListener(this);
        l5.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        f.setSize(500,500);
        f.setLocation(500,250); 
        f.setVisible(true);
    }
   
    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==b)
        {
            try
            {
                conn con = new conn();
                String str = "SELECT Company_Name, Contact_Number, Invoice_Number, Invoice_Date, Amount, Amount_Paid, Due_Date FROM accounts WHERE Invoice_Number = '"+t.getText()+"' ";
                ResultSet rs = con.s.executeQuery(str);

                int i=0;
                if(rs.next())
                {
                    String Company_Name = rs.getString(1);
                    String Invoice_Date = rs.getString(4);
                    String Amount = rs.getString(5);

                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);   
                    i=1;
                    l6.setText(Company_Name);
                    l7.setText(Invoice_Date);
                    l8.setText(Amount);
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null,"Bill Not Found");
            }
            catch(Exception ex)
            {}
        }
        if(ae.getSource()==b1)
        {
            try
            {
                conn con = new conn();
                String str = "DELETE FROM accounts WHERE Invoice_Number = '"+t.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"deleted successfully");
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);

            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,"Exception occured while delting record "+ex);
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[]ar){
        new Remove_Bill();
    }
}

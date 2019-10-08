package ledger;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Add_Bill implements ActionListener
{
    JFrame frame;
    JLabel id15,title,company_name,person_name,contact_number,invoice_number,invoice_date,amount,amount_paid,due_date;
    JTextField t,c_name,p_name,c_number,i_number,i_date,amt,amt_paid,d_date;
    JButton b,b1,b2,b3;

    Add_Bill(int i){}
   
    Add_Bill(){
        frame = new JFrame("Legder");
        frame.setBackground(Color.white);
        frame.setLayout(null);
        
        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        
        title = new JLabel("Add New Bill");
        title.setBounds(320,30,500,50);
        title.setFont(new Font("serif",Font.BOLD,25));
        title.setForeground(Color.black);
        frame.add(title);
        frame.add(id15);

        company_name = new JLabel("Company Name");
        company_name.setBounds(50,150,200,30);
        company_name.setFont(new Font("serif",Font.BOLD,20));
        id15.add(company_name);

        c_name=new JTextField();
        c_name.setBounds(200,150,150,30);
        id15.add(c_name);

        person_name = new JLabel("Contact Person's Name");
        person_name.setBounds(400,150,200,30);
        person_name.setFont(new Font("serif",Font.BOLD,20));
        id15.add(person_name);

        p_name = new JTextField();
        p_name.setBounds(600,150,150,30);
        id15.add(p_name);

        contact_number = new JLabel("Contact Number");
        contact_number.setBounds(50,200,200,30);
        contact_number.setFont(new Font("serif",Font.BOLD,20));
        id15.add(contact_number);

        c_number = new JTextField();
        c_number.setBounds(200,200,150,30);
        id15.add(c_number);

        invoice_number = new JLabel("Invoice Number"); 
        invoice_number.setBounds(400,200,200,30);
        invoice_number.setFont(new Font("serif",Font.BOLD,20));
        id15.add(invoice_number);

        i_number = new JTextField();
        i_number.setBounds(600,200,150,30);
        id15.add(i_number);

        invoice_date = new JLabel("Invoice Date");
        invoice_date.setBounds(50,250,200,30);
        invoice_date.setFont(new Font("serif",Font.BOLD,20));
        id15.add(invoice_date);

        i_date = new JTextField();
        i_date.setBounds(200,250,150,30);
        id15.add(i_date);

        amount = new JLabel("Invoice Amount");
        amount.setBounds(400,250,200,30);
        amount.setFont(new Font("serif",Font.BOLD,20));
        id15.add(amount);

        amt = new JTextField();
        amt.setBounds(600,250,150,30);
        id15.add(amt);

        amount_paid = new JLabel("Amount Paid");
        amount_paid.setBounds(50,300,200,30);
        amount_paid.setFont(new Font("serif",Font.BOLD,20));
        id15.add(amount_paid);

        amt_paid = new JTextField();
        amt_paid.setBounds(200,300,150,30);
        id15.add(amt_paid);

        due_date = new JLabel("Due Date");
        due_date.setBounds(400,300,200,30);
        due_date.setFont(new Font("serif",Font.BOLD,20));   
        id15.add(due_date);

        d_date = new JTextField();
        d_date.setBounds(600,300,150,30);
        id15.add(d_date);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);
       
        id15.add(b);

        b1=new JButton("Cancel");  
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
       
        id15.add(b1);
       
        b.addActionListener(this);
        b1.addActionListener(this);
       
        frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(400,150);
    }

    public void actionPerformed(ActionEvent ae)
    {
        String cname = c_name.getText();
        String pname = p_name.getText();
        String cnumber = c_number.getText();
        String inumber = i_number.getText();
        String idate = i_date.getText();
        String iamt = amt.getText();
        String iamtp = amt_paid.getText();
        String ddate = d_date.getText();
        if(ae.getSource() == b)
        {
            try
            {
                conn cc = new conn();
                String q = "insert into accounts values('"+cname+"','"+pname+"','"+cnumber+"','"+inumber+"','"+idate+"','"+iamt+"','"+iamtp+"','"+ddate+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                frame.setVisible(false);
                new details();
            }
            catch(Exception ee)
            {
                System.out.println("The error is:"+ee);
            }
        }
        else if(ae.getSource() == b1)
        {
             frame.setVisible(false);
             new details();
        }
    }
    
    public static void main(String[ ] arg)
    {
        new Add_Bill();
    }
}

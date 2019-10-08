package ledger;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Bill extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"Contact_Number","Person_Name","Contact_Number","Invoice_Number","Invoice_Date","Amount","Amount_Paid", "Due_Date"};
    String y[][] = new String[20][8];
    int i=0, j=0;
    
    View_Bill(){
        super("View Bill");
        setSize(1200,650);
        setLocation(200,200);
        
        try{
            conn c1  = new conn();
            String s1 = "select * from accounts";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("Company_Name");
                y[i][j++]=rs.getString("Person_Name");
                y[i][j++]=rs.getString("Contact_Number");
                y[i][j++]=rs.getString("Invoice_Number");
                y[i][j++]=rs.getString("Invoice_Date");
                y[i][j++]=rs.getString("Amount");
                y[i][j++]=rs.getString("Amount_Paid");
                y[i][j++]=rs.getString("Due_Date");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
            setVisible(false);
            new details();
        }catch(Exception e){}
        
    }
    
    public static void main(String[] args){
        new View_Bill();
    }
    
}
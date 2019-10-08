package ledger;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class Update_Bill extends Add_Bill implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,lab,lab1, l1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11, tn1;
    JButton b,b1,b2,b3,bn1,bn2;
    String id_emp;

    Update_Bill()
    {
        super(0);
        f=new JFrame("update Inovice details");
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(450,250);
        f.setBackground(Color.white);
        f.setLayout(null);
   
        id15=new JLabel();
        id15.setBounds(0,0,900,500);
        id15.setLayout(null);
        
        id8 = new JLabel("Update Inovice Detail:");
        id8.setBounds(50,10,500,50);
        id8.setFont(new Font("serif",Font.BOLD,40));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        l1=new JLabel("Invoice Number:");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.black);
        Font f2 = new Font("serif",Font.BOLD,25);
        l1.setFont(f2);
        id15.add(l1);

        tn1=new JTextField();
        tn1.setBounds(250,50,150,30);
        id15.add(tn1);


        bn1=new JButton("Search");
        bn1.setBounds(200,100,100,30);
        bn1.addActionListener(this);
        id15.add(bn1);

        bn2=new JButton("Back");
        bn2.setBounds(360,100,100,30);  
        bn2.addActionListener(this);
        id15.add(bn2);
        
        id1 = new JLabel("Company Name:"); 
        id1.setBounds(50,100,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,100,150,30);
        id15.add(t1);

        id2 = new JLabel("Contact Person's Name:");
        id2.setBounds(400,100,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,100,150,30);
        id15.add(t2);

        id3= new JLabel("Contact Number");
        id3.setBounds(50,150,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,150,150,30);
        id15.add(t3);

        id4= new JLabel("Invoice Number");
        id4.setBounds(400,150,100,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,150,150,30);  
        id15.add(t4);

        id5= new JLabel("Invoice Date:");
        id5.setBounds(50,200,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,200,150,30);
        id15.add(t5);

        id6= new JLabel("Amount");
        id6.setBounds(400,200,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));   
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,200,150,30);
        id15.add(t6);

        id7= new JLabel("Amount Paid");
        id7.setBounds(50,250,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,250,150,30);
        id15.add(t7);

        id9= new JLabel("Due Date");
        id9.setBounds(400,250,100,30); 
        id9.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,250,150,30);
        id15.add(t8);

        b=new JButton("update");
        b.setBounds(250,400,100,30);
        b.addActionListener(this);
        id15.add(b);

        b1=new JButton("Cancel");
        b1.setBounds(450,400,100,30);
        b1.addActionListener(this);
        id15.add(b1);
        
        id1.setVisible(false);
        id2.setVisible(false);
        id3.setVisible(false);
        id4.setVisible(false);
        id5.setVisible(false);
        id6.setVisible(false);
        id7.setVisible(false);
        id9.setVisible(false);
        t1.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);
        t4.setVisible(false);
        t5.setVisible(false);
        t6.setVisible(false);
        t7.setVisible(false);
        t8.setVisible(false);
        b.setVisible(false);
        b1.setVisible(false);

    }

    int i=0;
    String age,dat;

    void showData(String s){
        try{
            conn con = new conn();
            String str = "select * from accounts where 'Invoice Number' = '"+s+"'";
            ResultSet rs = con.s.executeQuery(str);

            if(rs.next()){
                f.setVisible(true);
                i=1;

                t1.setText(rs.getString(1));
                t2.setText(rs.getString(2));
                t3.setText(rs.getString(3));
                t4.setText(rs.getString(4));
                t5.setText(rs.getString(5));
                t6.setText(rs.getString(6));
                t7.setText(rs.getString(7));
                t8.setText(rs.getString(8));

            }
            if(i==0)
                JOptionPane.showMessageDialog(null,"Id not found");
        }catch(Exception ex){}
        f.setVisible(true);
        f.setSize(900,500);
        f.setLocation(400,100);
    }

    public void actionPerformed(ActionEvent ae){
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
                    id1.setVisible(true);
                    id2.setVisible(true);
                    id3.setVisible(true);
                    id4.setVisible(true);
                    id5.setVisible(true);
                    id6.setVisible(true);
                    id7.setVisible(true);
                    id9.setVisible(true);
                    t1.setVisible(true);
                    t2.setVisible(true);
                    t3.setVisible(true);
                    t4.setVisible(true);
                    t5.setVisible(true);
                    t6.setVisible(true);
                    t7.setVisible(true);
                    t8.setVisible(true);
                    b.setVisible(true);
                    b1.setVisible(true);
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null,"Bill Not Found");
            }
            catch(Exception ex)
            {}
        }
        if(ae.getSource()==b && i==1){
            try{
                conn con = new conn();
                String str = "update accounts set 'Company Name'='"+t1.getText()+"','Person Name'='"+t2.getText()+"','Contact Number'='"+age+"', 'Invoice Date'='"+t3.getText()+"','Amount'='"+t4.getText()+"','Amount Paid'='"+t5.getText()+"','Due Date'='"+t6.getText()+"' where 'Invoice Number'='"+id_emp+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"successfully updated");
                f.setVisible(false);
                new Search_Bill();
            }catch(Exception e){
                System.out.println("The error is:"+e);
            }
        }
        if(ae.getSource()==b1){
            f.setVisible(false);
            details d=new details();
        }
    }

    public static void main(String[] arg){
        new Update_Bill();
    }
}

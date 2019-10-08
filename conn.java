package ledger;
import java.sql.*;

public class conn 
{
    public Connection c;
    public Statement s;
    public conn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost/ledger","root", "");
            s = c.createStatement();
            System.out.print("Database is connected !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) 
    {
        conn c = new conn();
    }
}

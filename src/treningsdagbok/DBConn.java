package treningsdagbok;

import java.sql.*;
import java.util.Properties;


public class DBConn {


	Connection conn = null;

    public void connect() {
        String user = "<user>";
        String password = "<password>";
        String url = "<url>";

        Properties p = new Properties();
        p.put("user", user);
        p.put("password", password);


       // Class.forName("com.mysql.jdbc.Driver").newInstance();
        try{
            conn = DriverManager.getConnection(url, p);
        }
        catch(SQLException e){
            System.out.println("SQLException " + e.getMessage());
        }



    }

}

import java.sql.*;
import java.util.Properties;


public class DBConn {


    Connection conn = null;

    public Connection connect() {
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/prosjekt";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }catch(Exception e){
            e.printStackTrace();
        }

        Properties p = new Properties();
        p.put("user", user);
        p.put("password", password);
        try{
            conn = DriverManager.getConnection(url, p);
        }
        catch(SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        }
        return conn;
    }
    // hei

}
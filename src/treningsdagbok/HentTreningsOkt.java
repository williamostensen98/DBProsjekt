package treningsdagbok;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HentTreningsOkt() extends DBConn{

    public void hentTreningsOkter(int n){

        Statement statement = null;
        ResultSet resultat = null;

        try{
            statement = conn.createStatement()
            result = statement.executeQuery("SELECT * FROM Treningsokt ORDER BY Treningsokt.Tidsstempel DESC LIMIT "
            + " " + n  + ";");

            while(result.next()){
                System.out.println("Tidsstempel " + result.getString(1) + " Varighet: " + result.getString(2) + " Form: " + result.getString(3) + " Prestasjon: " + result.getString(4) + " Notat: " + result.getString(5));
            }
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

}
package treningsdagbok;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

public class Registrer extends DBConn {

    Statement statement = null;

    public void registrer_treningsokt(Date tidsstempel, int varighet, int form, int prestasjon, String notat){
        try{
            String query = "INSERT INTO Treningsokt(Tidsstempel, varighet, form, prestasjon, notat)"
                             + "VALUES ('"+tidsstempel+"', "+varighet+","+form+","+prestasjon+", '" + notat + "')";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

    }

    public void registrer_apparat(int apparatid, String apparat_navn) {
        try {
            String query = "INSERT INTO Apparat(apparatid, apparat_navn) "
                    + "VALUES (" + apparatid + ", '" + apparat_navn+"')";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }
    }



}

package treningsdagbok;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;

public class Registrer extends DBConn {

    Statement statement = null;

    //Registrer treningsøkter, apparater og øvelser

    public void registrer_treningsokt(Date tidsstempel, int varighet, int form, int prestasjon, String notat){
        try{
            String query = "INSERT INTO Treningsokt(Tidsstempel, Varighet, Form, Prestasjon, Notat)"
                             + "VALUES ('"+tidsstempel+"', "+varighet+","+form+","+prestasjon+", '" + notat + "')";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

    }

    public void registrer_apparat(String apparat_navn) {
        try {
            String query = "INSERT INTO Apparat "
                            + "VALUES ('" +apparat_navn+"')";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }
    }

    public void registrer_ovelse(String ovelse_navn , String beskrivelse, int antall_kilo, int antall_sett, int type, int apparatid) {
        try {
            String query = "INSERT INTO Ovelse "
                             + "VALUES ('"+ ovelses_navn + "', '"+beskrivelse+"', "+antall_kilo+", "+antall_sett+", "+type+","+apparatid+")";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }
    }


}

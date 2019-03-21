import java.sql.*;

public class Registrer extends DBConn {

    Statement statement = null;

    //Registrer treningsøkter, apparater og øvelser

    public void registrer_treningsokt(Connection conn,String tidsstempel, int varighet, int form, int prestasjon, String treningsformal,String opplevelse){
        try{
            String query = "INSERT INTO Treningsokt(Tidsstempel, Varighet, Form, Prestasjon)"
                    + "VALUES ('"+tidsstempel+"', "+varighet+","+form+","+prestasjon+");";
            String query2= "INSERT INTO Treningsnotat(Tidsstempel, treningsformål, opplevelse) " +
                    "VALUES ('"+tidsstempel+"','"+treningsformal+"','"+opplevelse+"');";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            statement.executeUpdate(query2);
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

    }

    public void registrer_apparat(Connection conn,int apparatID, String apparat_navn) {
        try {
            String query = "INSERT INTO Apparat VALUES ("+apparatID+",'"+apparat_navn+"');";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }
    }

    public void registrer_ovelse(Connection conn, String ovelse_navn , String beskrivelse, int antall_kilo, int antall_sett, int type, int apparatid) {
        try {
            String query = "INSERT INTO Ovelse "
                    + "VALUES ('"+ ovelse_navn + "', '"+beskrivelse+"', "+antall_kilo+", "+antall_sett+", "+type+","+apparatid+")";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }
        catch(SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }
    }


}
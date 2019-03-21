package treningsdagbok;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class NyOvelsegruppe extends DBConn {
	
	ResultSet rs = null;
	
	  // Legger til en ny gruppe i OvelseGruppe hvis den ikke finnes fra før
    public void nyOvelseGruppe(String gruppeNavn) {
        try {    
            String query = String.format("SELECT Muskelgruppe FROM OvelseGruppe WHERE Muskelgruppe = %s", gruppeNavn);
            Statement statement = conn.createStatement();
            if (statement.execute(query)) {
                System.out.println(String.format("Muskelgruppen: %s, eksisterer allerede i databasen", gruppeNavn));
                return;
            }
            String update = String.format("INSERT INTO OvelseGruppe Muskelgruppe(%s)",  gruppeNavn);
            statement.executeUpdate(update);
            System.out.println(String.format("Gruppen %s ble lagt til i databasen", gruppeNavn));
        } 
        catch (SQLException e) {
        	System.out.println("SQLException " + e.getMessage());
        }
    }
    
    // Henter ut gruppeID basert paa gruppeNavn, og setter saa inn (gruppeID, ovelseNavn) i OvelseIGruppe
    public void leggTilOvelseIGruppe(String gruppeNavn, String ovelseNavn) {
         try {
        	 String query = String.format("SELECT GruppeID FROM OvelseGruppe WHERE Muskelgruppe = %s", gruppeNavn);
        	 Statement statement = conn.createStatement();
        	 if (!statement.execute(query)) {
        		// Kommer man hit saa eksisterer det ingen gruppe med det navnet. Vi oppretter en slik gruppe.
        		 nyOvelseGruppe(gruppeNavn);
        		 statement.execute(query);
        	 }
        	 rs = statement.getResultSet();
    		 int gruppeID = rs.getInt(1);
    		 String update = String.format("INSERT INTO OvelseIGruppe VALUES(%d, '%s');", gruppeID, ovelseNavn );
    		 statement.executeUpdate(update);
    		 System.out.println(String.format("Ovelse: %s er satt inn i gruppe: %d (%s)", ovelseNavn, gruppeID, gruppeNavn));
		} 
        catch (SQLException e) {
        	System.out.println("SQLException " + e.getMessage());
		}
    }
    
    // Henter ut gruppeNavn basert paa gruppeID, og setter saa inn (gruppeID, ovelseNavn) i OvelseIGruppe.
    // gruppeNavn hentes ut for aa printes ut saa man faar output som kan vise om man satte inn i onsket gruppe
    public void leggTilOvelseIGruppe(int gruppeID, String ovelseNavn) {
    	try {
    		String query = String.format("INSERT INTO Muskelgruppe FROM OvelseGruppe WHERE GruppeID = %d", gruppeID);
       	 	Statement statement = conn.createStatement();
       	 	statement.execute(query);
       	 	rs  = statement.getResultSet();
       	 	String gruppeNavn = rs.getString(2);			// Henter ut gruppeNavn
       	 	String update = String.format("INSERT INTO OvelseIGruppe VALUES(%d, '%s');", gruppeID, ovelseNavn );
       	 	statement.executeUpdate(update);
       	 	System.out.println(String.format("Ovelse: %s er satt inn i gruppe: %d (%s)", ovelseNavn, gruppeID, gruppeNavn));
    	}
    	catch (SQLException e) {
    		System.out.println("SQLException " + e.getMessage());
    	}
    }
}

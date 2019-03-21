package treningsdagbok;

import java.sql.*;

public class NyOvelsegruppe extends DBConn {
	
	ResultSet rs = null;
	
	// Finner gruppeID ved hjelp av gruppeNavn
	public int getGruppeID(String gruppeNavn) throws SQLException {
	    String query = String.format("SELECT GruppeID FROM ØvelseGruppe WHERE Muskelgruppe = %s", gruppeNavn);
	    Statement statement = conn.createStatement();
	    statement.execute(query);
   	 	rs  = statement.getResultSet();
   	 	return rs.getInt(1);
	}
	
	// Finner gruppeNavn ved hjelp av gruppeID
	public String getGruppeNavn(int gruppeID) throws SQLException {
		String query = String.format("SELECT GruppeID FROM ØvelseGruppe WHERE Muskelgruppe = %s", gruppeID);
	    Statement statement = conn.createStatement();
	    statement.execute(query);
   	 	rs  = statement.getResultSet();
   	 	return rs.getString(1);
	}
	
	// Legger til en ny gruppe i OvelseGruppe hvis den ikke finnes fra før
    public void nyOvelseGruppe(String gruppeNavn) {
        try {    
            String query = String.format("SELECT Muskelgruppe FROM ØvelseGruppe WHERE Muskelgruppe = %s", gruppeNavn);
            Statement statement = conn.createStatement();
            if (statement.execute(query)) {
                System.out.println(String.format("Muskelgruppen: %s, eksisterer allerede i databasen", gruppeNavn));
                return;
            }
            String update = String.format("INSERT INTO ØvelseGruppe Muskelgruppe(%s)",  gruppeNavn);
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
        	 String query = String.format("SELECT GruppeID FROM ØvelseGruppe WHERE Muskelgruppe = %s", gruppeNavn);
        	 Statement statement = conn.createStatement();
        	 if (!statement.execute(query)) {
        		// Kommer man hit saa eksisterer det ingen gruppe med det navnet. Vi oppretter en slik gruppe.
        		 nyOvelseGruppe(gruppeNavn);
        		 statement.execute(query);
        	 }
        	 rs = statement.getResultSet();
    		 int gruppeID = rs.getInt(1);
    		 String update = String.format("INSERT INTO ØvelseIGruppe VALUES(%d, '%s');", gruppeID, ovelseNavn );
    		 statement.executeUpdate(update);
    		 System.out.println(String.format("Øvelse: %s er satt inn i gruppe: %d (%s)", ovelseNavn, gruppeID, gruppeNavn));
		} 
        catch (SQLException e) {
        	System.out.println("SQLException " + e.getMessage());
		}
    }
    
    // Finner GruppeNavn ved hjelp av finnGruppeNavn, og kjorer saa leggTilOvelseIGruppe med (gruppeNavn, ovelseNavn)
    public void leggTilOvelseIGruppe(int gruppeID, String ovelseNavn) {
    	try {
			leggTilOvelseIGruppe(getGruppeNavn(gruppeID), ovelseNavn);
		} catch (SQLException e) {
			System.out.println("SQLException " + e.getMessage());
		}
    }
    
    // Finner andre ovelser i samme gruppe som oppgitt ovelse
    public String finnAndreOvelserIGruppe(String ovelseNavn) {
    	try {
	    	String query = String.format("SELECT Navn FROM ØvelseIGruppe WHERE GruppeID = "
	    			+ "(SELECT GruppeID FROM ØvelseIGruppe WHERE Navn = '%s');", ovelseNavn);
	    	Statement statement = conn.createStatement();
	   	 	statement.execute(query);
	   	 	rs  = statement.getResultSet();
	   	 	String result = "";
	   	 	while (rs.next()) {
	   	 		result += rs.getString(1) + "\n";
	   	 	}
	   	 	System.out.println(result);
	   	 	return result;
	   	 	
    	}
    	catch (SQLException e) {
    		System.out.println("SQLException " + e.getMessage());
    	}
		return null;
    }
    
    // Finner ovelser i en gruppe ved hjelp av gruppeID
    public String finnOvelserIGruppe(int gruppeID) {
    	String query = String.format("SELECT Navn FROM ØvelseIGruppe WHERE GruppeID = %d", gruppeID);
    	try {
			Statement statement = conn.createStatement();
			statement.execute(query);
	   	 	rs  = statement.getResultSet();
	   	 	String result = "";
	   	 	while (rs.next()) {
	   	 		result += rs.getString(1) + "\n";
	   	 	}
	   	 	System.out.println(result);
	   	 	return result;
		} 
    	catch (SQLException e) {
			System.out.println("SQLException " + e.getMessage());
		}
    	return null;
    }
    
    // Finner ovelser i en gruppe ved hjelp av gruppeNavn
    // Finner gruppeID ved hjelp av gruppeNavn, og finner saa ovelser i denne gruppen
    public String finnOvelserIGruppe(String gruppeNavn) {
    	try {
			return finnOvelserIGruppe(getGruppeID(gruppeNavn));
		} catch (SQLException e) {
			System.out.println("SQLException " + e.getMessage());
		}
    	return null;
    }
}

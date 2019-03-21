package treningsdagbok;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class nyeGrupper extends DBConn{


    // Legger til en ny gruppe i ØvelseGruppe hvis den ikke finnes fra før
    public static void nyØvelseGruppe(String groupName) {
        try {
            String query = String.format("SELECT Muskelgruppe FROM ØvelseGruppe WHERE Muskelgruppe = %s", groupName);
            Statement statement = conn.createStatement();
            if (statement.execute(query)) {
                System.out.println(String.format("Muskelgruppen: %s, eksisterer allerede i databasen", groupName));
                return;
            }
            String update = String.format("INSERT INTO ØvelseGruppe Muskelgruppe(%s)",  groupName);
            statement.executeUpdate(update);
            System.out.println(String.format("Gruppen %s ble lagt til i databasen", groupName));
        }
    }


}

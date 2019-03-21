import java.sql.*;

public class HentTreningsokt{

public void hentTreningsOkter(Connection conn,int n){

        Statement statement=null;

        try{
        statement=conn.createStatement();
        ResultSet result=statement.executeQuery("SELECT * FROM (Treningsokt LEFT JOIN treningsnotat ON treningsokt.tidsstempel=treningsnotat.tidsstempel) ORDER BY treningsokt.tidsstempel DESC LIMIT "+n+";");

        while(result.next()){
        System.out.println("Tidsstempel "+result.getDate("tidsstempel")+" Varighet: "+result.getInt("varighet")+" Form: "+result.getInt("form")+" Prestasjon: "+result.getInt("prestasjon")+" Notat: Treningsformål:"+result.getString("treningsformål")+" Opplevelse: "+result.getString("opplevelse"));
        }
        }
        catch(SQLException ex){
        System.out.println("SQLException "+ex.getMessage());
        }

        }
}
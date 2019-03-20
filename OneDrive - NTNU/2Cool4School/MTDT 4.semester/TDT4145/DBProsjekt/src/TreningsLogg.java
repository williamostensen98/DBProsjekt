import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreningsLogg extends DBConn{

    Statement statement=null;
    ArrayList<String> values=new ArrayList<>(6);

    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    private String createHeader(){
        String output="";
        values.add("Tidsstempel");values.add("Navn");values.add("Form på økt");values.add("Prestasjon på økt");values.add("Antall kilo");values.add("Antall sett");
        for (String value : values){
            output+=padRight(value,20);
        }
        return output;
    }

    public void getTreningsLogg(Connection conn,String ovelsenavn, String start,String end,Boolean ascending){
        String sortby=ascending?"ASC":"DESC";
        String query="SELECT tidsstempel, navn, form, prestasjon, antallkilo, antallsett " +
                "FROM (ovelse NATURAL JOIN ovelseiokt) NATURAL JOIN treningsokt WHERE " +
                "ovelsestype=1 AND navn='"+ovelsenavn+"' AND tidsstempel BETWEEN '"+start+"' AND '"+end+"' " +
                "ORDER BY tidsstempel "+sortby+";";
        try{
            statement=conn.createStatement();
            ResultSet rs=statement.executeQuery(query);
            System.out.println(createHeader());
            while (rs.next()){
                Date tidsstempel=rs.getDate("tidsstempel");
                String navn=rs.getString("navn");
                int form=rs.getInt("form");
                int prestasjon=rs.getInt("prestasjon");
                int antallkilo=rs.getInt("antallkilo");
                int antallsett=rs.getInt("antallsett");

                String output=String.format("%s%s%s%s%s%s",padRight(tidsstempel.toString(),20),
                        padRight(navn,20),
                        padRight(Integer.toString(form),20),
                        padRight(Integer.toString(prestasjon),20),
                        padRight(Integer.toString(antallkilo),20),
                        padRight(Integer.toString(antallsett),20));
                System.out.println(output);
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}

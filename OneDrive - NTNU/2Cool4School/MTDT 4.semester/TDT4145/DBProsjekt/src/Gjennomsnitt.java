import java.sql.*;
import java.util.ArrayList;

public class Gjennomsnitt {


    Statement statement=null;

    public void getGjennomsnitt(Connection conn,String start,String end){
        String query="SELECT form FROM treningsokt WHERE tidsstempel BETWEEN '"+start+"' AND '"+end+"';";
        ArrayList<Integer> values=new ArrayList<>();

        try{
            statement=conn.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while (rs.next()){
                values.add(rs.getInt("form"));
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        int temp=0;
        for(int i:values){
            temp+=i;
        }
        System.out.println("Gjennomsnittlig form i periode "+start+" - "+end+": "+(temp/values.size()));
    }
}

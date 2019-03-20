import java.sql.*;

public class Main {

    public static void main(String[] args){
        DBConn dbconn=new DBConn();
        Registrer registrer=new Registrer();
        TreningsLogg logg=new TreningsLogg();
        Gjennomsnitt gjsnitt=new Gjennomsnitt();
        Connection conn=dbconn.connect();
        logg.getTreningsLogg(conn,"Nedtrekk","2019-01-01","2019-03-19",false);
        gjsnitt.getGjennomsnitt(conn,"2019-01-01","2019-03-19");
    }
}

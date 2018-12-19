package reUseDB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestConnectDB {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        String query = "select * from customers where level = 'Silver'";
        Statement statement = ConnectDB.connectToMySql().createStatement();
        ResultSet rsSet = statement.executeQuery(query);


        rsSet.next();
        System.out.println(rsSet.getString("id")+" "+rsSet.getString("level"));

    }
}

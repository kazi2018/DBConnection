package dbConnection;

import java.sql.*;


public class MySqlConnection {

    public static Connection connectMysql() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/safwan?useSSL=false&allowPublicKeyRetrieval=true";
        String userName = "root";
        String passWord = "Safwan2018";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connect = DriverManager.getConnection(url, userName, passWord);// Connection is an interface,
        return connect;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //retrieve data from DB
        String query = "select * from customers";
        Statement statement = connectMysql().createStatement();// Statement is an interface
        ResultSet rsSet = statement.executeQuery(query);// ResultSet is an interface

        while (rsSet.next()){
            System.out.println(rsSet.getString("id")+" | "+rsSet.getString("name")+" | "+rsSet.getString("level"));
        }

        statement.close();

    }

}

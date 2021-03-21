package methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static String url = "jdbc:mysql://localhost:3306/2001assign2";
    static String user = "2001assign2";
    static String password = "assign2";
    static Connection conn = null;
    public static Connection getconn(){
        try{
            conn =  DriverManager.getConnection(url, user, password);
            System.out.println("Connect Successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }// getconn

}

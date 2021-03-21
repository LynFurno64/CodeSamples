package methods;

import members.Appointment;
import members.Customer;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class connectMethod {
    private Connection conn;

    public boolean openConnection() {
        try {
            // create a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/2001assign2", "2001assign2", "assign2");
            if (conn != null)
                System.out.println("Connection Successful");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }// openConnection

    public void closeConnection() {

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }// closeConnection

    /**
     * Appointment Insertion
     */
    public void insertAppointment(Appointment user) {
        //the mysql insert statement
        String query =
                "insert into appointment values (?,?,?,?,?,?,?,?)";

        //create the mysql insert preparedstatement
        try {
            PreparedStatement myPreStmt = conn.prepareStatement(query);
            myPreStmt.setString(1, user.getID());
            myPreStmt.setString(2, user.getFullname());
            myPreStmt.setString(3, user.getPh_num());
            myPreStmt.setString(4, user.getEmail());
            myPreStmt.setString(5, user.getDate());
            myPreStmt.setString(6, user.getTime());
            myPreStmt.setString(7, user.getReason());
            myPreStmt.setString(8, user.getYesno());

            System.out.println(myPreStmt);
            //execute the preparedstatement
            myPreStmt.execute();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

    }// insertCusRecord

    public Customer findCusRecord(String id)
    {
        Customer theOne = null;
        //the mysql insert statement
        String query = "select * from addclient where id = ?";

        try{
            //create the mysql insert preparedstatement
            PreparedStatement myPreStmt = conn.prepareStatement(query);
            myPreStmt.setString(1, id);

            //execute the preparedstatement
            ResultSet rs = myPreStmt.executeQuery();
            while (rs.next()) {
                theOne = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                                     rs.getString(5), rs.getString(6), rs.getString(7),
                                     rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                                     rs.getString(12), rs.getString(13));
            }
        }
        catch (Exception e){
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
        return theOne;
    }// findCusRecord

}

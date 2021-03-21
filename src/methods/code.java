package methods;

import members.Customer;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class code  {
    JFrame f = new JFrame();
    Connection conn = null;

    int getvalue;
    String i = "";

    public void generateID(String passQuery) {
        conn = DatabaseConnection.getconn();
        try{
            Statement st = conn.createStatement();
            ResultSet set = st.executeQuery(passQuery);
            if(set.next()){
                getvalue = Integer.parseInt(set.getString(1));
            }

        } catch (Exception e){
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }// generateID

    public void insertSerialNo(Customer end){
        generateID("select count(*)+1 from addclient");
        String insertdata = "insert into addclient values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        conn = DatabaseConnection.getconn();
        String idv = "ID"+ new SimpleDateFormat("ddMMyy").format(new Date())+ getvalue;
        try{
            PreparedStatement ps = conn.prepareStatement(insertdata);
            end.setId(idv);
            ps.setString(1, end.getId());
            ps.setString(2,end.getName());
            ps.setString(3,end.getSurname());
            ps.setString(4, end.getGender());
            ps.setString(5, end.getBirthday());
            ps.setString(6, end.getAddress());
            ps.setString(7, end.getCountry());
            ps.setString(8, end.getProvince());
            ps.setString(9, end.getZip_code());
            ps.setString(10, end.getCell_num());
            ps.setString(11, end.getHome_num());
            ps.setString(12, end.getEmail());
            ps.setString(13, end.getPassword());
            ps.execute();
            JOptionPane.showMessageDialog(f, "<html><center><font size='3'- color=red><b>Your ID is <br>" + idv + "</b></font></html>");
            System.out.println("Insert success");
        } catch (Exception e){
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }// insertSerialNo

}

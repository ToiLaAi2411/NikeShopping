/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import Model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DUY
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    public boolean checkExistsAccount(String account) {
        String SQLQuery = "SELECT * FROM [User] WHERE Account = ?";

        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setString(1, account);

            rs = pt.executeQuery();

            if (rs.next()) {
                System.out.println("Account exists");
                return true;
            }

        } catch (Exception e) {
            System.out.println("method  checkExistsAccount: " + e.getMessage());
        }
        return false;
    }

    public User getUser(String account, String password) {
        String SQLQuery = "SELECT * FROM [User] WHERE Account = ? AND Password = ?";
        User user = null;

        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setString(1, account);
            pt.setString(2, password);

            rs = pt.executeQuery();

            if (rs.next()) {
                int userID = rs.getInt("UserID");
                String accountS = rs.getString("Account");
                String passwordS = rs.getString("Password");
                Date dob = rs.getDate("Dob");
                String phone = rs.getString("Phone");
                String email = rs.getString("Email");
                int gender = rs.getInt("Gender");
                String address = rs.getString("Address");
                
                user = new User(userID, account, password, dob, phone, email, gender, address);
                System.out.println("SELECT USER DONE");
            }
        } catch (Exception e) {
            System.out.println("ERROR IN METHOD selectUser: " + e.getMessage());
        }
        return user;
    }
    
    
    public void createUser(User userToCreate){
        String SQLQuery = "INSERT INTO [User]\n" +
                          "VALUES(?,?,?,?,?,?,?)";
        
        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setString(1, userToCreate.getAccount());
            pt.setString(2, userToCreate.getPassword());
            pt.setDate(3, userToCreate.getDob());
            pt.setString(4, userToCreate.getPhone());
            pt.setString(5, userToCreate.getEmail());
            pt.setInt(6, userToCreate.getGender());
            pt.setString(7, userToCreate.getAddress());
            
            int rowEffect = pt.executeUpdate();
            if(rowEffect > 0){
                System.out.println("create user done!");
            }else{
                System.out.println("Cannot create user");
            }
        } catch (Exception e) {
            System.out.println("Error in method createUser " + e.getMessage());
        }
        
    }
    
    public boolean changePassword(String account,String newPass){
        String SQLQuery = "UPDATE [User]\n" +
                          "SET Password = ?\n" +
                          "WHERE Account = ?";
        
        try {
            conn = new DBContext().getConnection();
            pt = conn.prepareStatement(SQLQuery);
            pt.setString(1, newPass);
            pt.setString(2, account);
            
            int rowEffect = pt.executeUpdate();
            if(rowEffect > 0){
                System.out.println("Update Successfully");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error occurred in method changePassword: " + e.getMessage());
        }
        return false;    
    }
}

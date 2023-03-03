/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Security.PasswordEncrypt;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class UserDAO {

    public void signUpUser(User acc) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
                
            
            
            String query = "INSERT INTO USER_ACCOUNT (USERNAME, PASSWORD, EMAIL, PHONE_NUMBER, CITY, PROVINCE, ADDRESS, AVATAR, NAME, ROLE, DOB, BANK_ACCOUNT, SALT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,  acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getPhoneNumber());
            ps.setString(5, acc.getCity());
            ps.setString(6, acc.getProvince());
            ps.setString(7, acc.getAddress());
            ps.setString(8, acc.getAvatar());
            ps.setString(9, acc.getName());
            ps.setString(10, acc.getRole());
            ps.setString(11, acc.getDob());
            ps.setString(12, acc.getBank_account());
            ps.setString(13, acc.getSalt());
            
            ps.executeUpdate();

//            rs = ps.getGeneratedKeys();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public User login(String username, String password) {
        
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "SELECT * FROM USER_ACCOUNT WHERE USERNAME=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            User ud = null;
            while (rs.next()) {
                ud = (new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("city"),
                        rs.getString("province"), rs.getString("address"), rs.getString("name"), rs.getString("role"), rs.getString("avatar"), rs.getString("phone_number"),  rs.getString("dob"), rs.getString("bank_account"), rs.getString("salt")));
                

                break;

            }

            if (ud != null) {
                Boolean status = PasswordEncrypt.verifyUserPassword(password, ud.getPassword(), ud.getSalt());
                if (status == true) {
                    ud.setPassword(null);
                    ud.setSalt(null);
                    return ud;
                }
            }

            return null;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
//    Check if user is existed or not function
    public User checkExistedUsername(String username) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "SELECT * FROM USER_ACCOUNT WHERE USERNAME=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            User userAcc = null;
            while (rs.next()) {
                userAcc = User.builder()
                        .user_id(rs.getInt("user_id"))
                        .username(rs.getString("username"))
                        .password(null)
                        .email(rs.getString("email"))
                        .phoneNumber(rs.getString("phone_number"))
                        .city(rs.getString("city"))
                        .province(rs.getString("province"))
                        .address(rs.getString("address"))
                        .avatar(rs.getString("avatar"))
                        .name(rs.getString("name"))
                        .role(rs.getString("role"))
                        .dob(rs.getString("dob"))
                        .bank_account(rs.getString("bank_account"))
                        .salt(null).build();
                
            }
            return userAcc;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    

}

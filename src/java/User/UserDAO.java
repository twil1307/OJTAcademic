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

    public int signUpAccount(Account acc) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "INSERT INTO ACCOUNT (USERNAME, PASSWORD, ROLE_ID, SALT) VALUES (?, ?, ?, ?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setInt(3, acc.getRole());
            ps.setString(4, acc.getSalt());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public void signUpDonor(Donor donor) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "INSERT INTO DONOR (ACCOUNT_ID, EMAIL, PHONE_NUMBER, CITY, PROVINCE, ADDRESS, AVATAR, NAME, DOB, BANK_ACCOUNT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, donor.getAccountId());
            ps.setString(2, donor.getEmail());
            ps.setString(3, donor.getPhoneNumber());
            ps.setString(4, donor.getCity());
            ps.setString(5, donor.getProvince());
            ps.setString(6, donor.getAddress());
            ps.setString(7, donor.getAvatar());
            ps.setString(8, donor.getName());
            ps.setString(9, donor.getDob());
            ps.setString(10, donor.getBank_account());

            ps.executeUpdate();

//            rs = ps.getGeneratedKeys();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account login(String username, String password) {

        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select acc.username, acc.password, acc.role_id, acc.salt, don.* from donor as don, account as acc where acc.account_id=don.account_id and username=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            Account ud = null;
            while (rs.next()) {
                ud = (new Donor(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"), rs.getInt("role_id"), rs.getString("salt"),
                        rs.getInt("donor_id"), rs.getString("email"), rs.getString("city"), rs.getString("province"), rs.getString("address"), rs.getString("name"), rs.getString("avatar"), rs.getString("phone_number"), rs.getString("dob"), rs.getString("bank_account")));

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
    public Account checkExistedUsername(String username) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select acc.username, acc.password, acc.role_id, acc.salt, don.* from donor as don, account as acc where acc.account_id=don.account_id and username=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, username);

            rs = ps.executeQuery();

            Account userAcc = null;
            while (rs.next()) {
                userAcc = (new Donor(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"), rs.getInt("role_id"), rs.getString("salt"),
                        rs.getInt("donor_id"), rs.getString("email"), rs.getString("city"), rs.getString("province"), rs.getString("address"), rs.getString("name"), rs.getString("avatar"), rs.getString("phone_number"), rs.getString("dob"), rs.getString("bank_account")));

            }

            if (userAcc != null) {
                userAcc.setPassword(null);
                userAcc.setSalt(null);
                return userAcc;

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //    Get user by ID
    public Account getUserByID(int userID) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select acc.username, acc.role_id, don.* from donor as don, account as acc where acc.account_id=don.account_id and acc.account_id=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);

            rs = ps.executeQuery();

            Account userAcc = null;
            while (rs.next()) {
                userAcc = (new Donor(rs.getInt("account_id"), rs.getString("username"), null, rs.getInt("role_id"), null,
                        rs.getInt("donor_id"), rs.getString("email"), rs.getString("city"), rs.getString("province"), rs.getString("address"), rs.getString("name"), rs.getString("avatar"), rs.getString("phone_number"), rs.getString("dob"), rs.getString("bank_account")));

            }

            return userAcc;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



    public String getEmailByAccountID(int id) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select email from donor where account_id=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getString("email");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
            System.out.println(userDAO.getUserByID(4));
    }
}

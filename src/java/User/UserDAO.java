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
import java.util.ArrayList;
import java.util.List;
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

            String query = "INSERT INTO DONOR (ACCOUNT_ID, EMAIL, PHONE_NUMBER, CITY, PROVINCE, ADDRESS, AVATAR, NAME, DOB, BANK_ACCOUNT, BANK_MONNEY_AMOUNT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 50000)";
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

    public List<Account> listUser() {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select acc.username, acc.password, acc.role_id, acc.salt, don.* from donor as don, account as acc where acc.account_id=don.account_id and acc.role_id!=1 order by don.donor_id desc";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            List<Account> listUser = new ArrayList<>();
            while (rs.next()) {
                Account userAcc = (new Donor(rs.getInt("account_id"), rs.getString("username"), rs.getString("password"), rs.getInt("role_id"), rs.getString("salt"),
                        rs.getInt("donor_id"), rs.getString("email"), rs.getString("city"), rs.getString("province"), rs.getString("address"), rs.getString("name"), rs.getString("avatar"), rs.getString("phone_number"), rs.getString("dob"), rs.getString("bank_account")));
                listUser.add(userAcc);
            }

            return listUser;

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

    public void changeRole(int accountId, String roleCase) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = null;

            switch (roleCase) {
                case "user":
                    query = "update account set role_id=3 where account_id=?";
                    break;
                case "manager":
                    query = "update account set role_id=2 where account_id=?";
                    break;
            }

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);

            ps.executeUpdate();

//            rs = ps.getGeneratedKeys();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getManagerNumber() {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select count(1) as manager_count from account where role_id=2";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt("manager_count");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public double getUserDonateTotal(int accountId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select sum(amount) as total_amount from donate where donor_id = (select donor_id from donor where account_id=?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt("total_amount");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.getUserByID(4));
    }

    public int getUserContributeProgramNum(int accountId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select count(distinct(program_id)) as total_program from donate where donor_id = (select donor_id from donor where account_id=?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt("total_program");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    double getContributeThisMonth(int accountId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select sum(amount) as total_amount_month from donate where donor_id = (select donor_id from donor where account_id=?) and MONTH(donate_date) = MONTH(GETDATE())";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt("total_amount_month");

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    void updateBasicInfo(Donor acc) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "update donor set phone_number=?, city=?, province=?, address=?, avatar=?, name=?, dob=? where account_id=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, acc.getPhoneNumber());
            ps.setString(2, acc.getCity());
            ps.setString(3, acc.getProvince());
            ps.setString(4, acc.getAddress());
            ps.setString(5, acc.getAvatar());
            ps.setString(6, acc.getName());
            ps.setString(7, acc.getDob());
            ps.setInt(8, acc.getAccountId());

            ps.executeUpdate();

//            rs = ps.getGeneratedKeys();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void changeEmailAndBankAcc(Donor accUpdt) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "update donor set email=?, bank_account=? where account_id=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, accUpdt.getEmail());
            ps.setString(2, accUpdt.getBank_account());
            ps.setInt(3, accUpdt.getAccountId());

            ps.executeUpdate();

//            rs = ps.getGeneratedKeys();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void changePassword(String encryptedPassword, String saltValue, String userId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "update account set password=?, salt=? where account_id=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, encryptedPassword);
            ps.setString(2, saltValue);
            ps.setInt(3, Integer.parseInt(userId));

            ps.executeUpdate();

//            rs = ps.getGeneratedKeys();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

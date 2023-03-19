/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Donate;

import News.News;
import News.NewsDAO;
import News.NewsVO;
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
public class DonateDAO {

    public int getWalletAmount(int accountId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select bank_monney_amount from donor where account_id=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt("bank_monney_amount");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DonateDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DonateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public List<Donate> getListRecentDonateByProgramId(int programId) {

        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select dnt.*, dn.name, dn.account_id from donate dnt, donor dn where dnt.donor_id=dn.donor_id and program_id=? order by donate_date desc";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);

            rs = ps.executeQuery();

            List<Donate> listDonate = new ArrayList<>();
            while (rs.next()) {
                Donate donateAdd =  new DonateVO(rs.getInt("donate_id"), 0, rs.getInt("program_id"), rs.getDouble("amount"), rs.getString("donate_date"), rs.getString("message"), rs.getString("name"), rs.getInt("account_id"));
                
                listDonate.add(donateAdd);
            }

            return listDonate;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Donate> getListDonation() {

        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select dnt.*, dn.name, (select PROGRAM_NAME from program where program_id=dnt.program_id) as program_name from donate dnt, donor dn where dnt.donor_id=dn.donor_id order by donate_date desc";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            List<Donate> listDonate = new ArrayList<>();
            while (rs.next()) {
                Donate donateAdd =  new DonateVO(rs.getInt("donate_id"), 0, rs.getInt("program_id"), rs.getDouble("amount"), rs.getString("donate_date"), rs.getString("message"), rs.getString("name"), rs.getString("program_name"));
                
                listDonate.add(donateAdd);
            }

            return listDonate;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Donate> getDonateHistoryByUserId(int userId) {

        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select dn.*, pr.program_name from donate dn, program pr where dn.program_id=pr.program_id and dn.donor_id = (select donor_id from donor where account_id=?) order by donate_date desc";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);

            rs = ps.executeQuery();

            List<Donate> listDonate = new ArrayList<>();
            while (rs.next()) {
                Donate donateAdd =  new DonateVO(rs.getInt("donate_id"), 0, rs.getInt("program_id"), rs.getDouble("amount"), rs.getString("donate_date"), rs.getString("message"), null, rs.getString("program_name"));
                
                listDonate.add(donateAdd);
            }

            return listDonate;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void donate(Donate donate) throws SQLException, ClassNotFoundException {
        Connection conn = new DBContext().getConnection();
        PreparedStatement ps;
        ResultSet rs;

        conn.setAutoCommit(false);
        try {

            // Execute SQL statements within the transaction
            PreparedStatement statement1 = conn.prepareStatement("insert into donate values ((select donor_id from donor where account_id=?), ?, ?, GETDATE(), ?)");
            statement1.setInt(1, donate.getUser_id());
            statement1.setInt(2, donate.getProgram_id());
            statement1.setDouble(3, donate.getAmount());
            statement1.setString(4, donate.getMessage());

            statement1.executeUpdate();

            PreparedStatement statement2 = conn.prepareStatement("update donor set bank_monney_amount=(bank_monney_amount-?) where account_id=?");
            statement2.setDouble(1, donate.getAmount());
            statement2.setInt(2, donate.getUser_id());
            
            statement2.executeUpdate();

            // Commit the transaction if all statements execute successfully
            conn.commit();
        } catch (SQLException e) {
            // Rollback the transaction if an error occurs
            conn.rollback();
            e.printStackTrace();
        } finally {
            // Close the database connection
            conn.close();
        }
        
        
    }
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Donate donate = new Donate(0, 4, 2110, 2000, null, "aiowdaw doiawjd awio daw");
        DonateDAO dao = new DonateDAO();
        System.out.println(dao.getDonateHistoryByUserId(4));
    }
}

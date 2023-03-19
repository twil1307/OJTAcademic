/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Investor;

import News.News;
import News.NewsDAO;
import Operator.OperatorDAO;
import context.DBContext;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class InvestorDAO {

    public void saveInvestors(List<Investor> investor) throws SQLException {
        String INSERT_NEWS_IMG = "insert into investor values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEWS_IMG)) {
            connection.setAutoCommit(false);
            for (int i = 0; i < investor.size(); i++) {
                preparedStatement.setInt(1, investor.get(i).getProgramId());
                preparedStatement.setString(2, investor.get(i).getInvestorName());
                preparedStatement.setString(3, investor.get(i).getInvestorImg());
                preparedStatement.setString(4, investor.get(i).getInvestorDes());
                preparedStatement.setString(5, investor.get(i).getContact());
                preparedStatement.setString(6, investor.get(i).getQualifyImg());
                preparedStatement.setString(7, investor.get(i).getLegalRepresent());

                preparedStatement.addBatch();
            }

            int[] updateCounts = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
            connection.commit();
            connection.setAutoCommit(true);
        } catch (BatchUpdateException batchUpdateException) {
            Logger.getLogger(InvestorDAO.class.getName()).log(Level.SEVERE, null, batchUpdateException);
        } catch (SQLException ex) {
            Logger.getLogger(InvestorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InvestorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Investor> getListInvestorsByProgramId(int programId) {

        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select * from investor where program_id=? order by investor_id asc";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);

            rs = ps.executeQuery();

            List<Investor> listInvestors = new ArrayList<>();
            while (rs.next()) {
                Investor donateAdd = new Investor(rs.getInt("investor_id"), rs.getInt("program_id"), rs.getString("investor_name"), rs.getString("investor_img"), rs.getString("investor_des"), rs.getString("contact"), rs.getString("qualify_img"), rs.getString("legal_represent"));

                listInvestors.add(donateAdd);
            }

            return listInvestors;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getInvestorImg(int investorId) {

        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select investor_img from investor where investor_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, investorId);

            rs = ps.executeQuery();

            
            while (rs.next()) {
                return rs.getString("investor_img");
            }


        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public String getQualifyImg(int investorId) {

        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select qualify_img from investor where investor_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, investorId);

            rs = ps.executeQuery();

            
            while (rs.next()) {
                return rs.getString("qualify_img");
            }


        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     void deleteMultipleInvestor(String[] investorIdDels) {
        Connection conn;
        PreparedStatement ps;

        try {

            String query = "delete from investor where investor_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            for (String id : investorIdDels) {
                ps.setInt(1, Integer.parseInt(id));
                ps.addBatch();
            }

            ps.executeBatch();

            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(OperatorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        InvestorDAO dao = new InvestorDAO();
        
        System.out.println(dao.getListInvestorsByProgramId(2143));
    }
}


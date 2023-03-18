/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Image;

import Operator.OperatorImage;
import Program.ProgramImage;
import Schedule.ScheduleImage;
import User.UserDAO;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ImageDAO {

    public void addImage(List<? extends Image> images, String tableName) {

        switch (tableName) {
            case "program_img":
                addProgramImage((List<ProgramImage>) images);
                break;
            case "schedule_img":
                addScheduleImage((List<ScheduleImage>) images);
                break;
            case "activies_img":
                addActivitiesImage((List<OperatorImage>) images);
                break;

            case "bill_img":
                addBillsImage((List<OperatorImage>) images);
                break;
        }
    }

    public void addProgramImage(List<ProgramImage> images) {
        try {
            String sql = "insert into program_img(program_id, program_img_path) values(?, ?)";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // TOBE: Implement update based on batch size
            int BATCH_SIZE = 200;

            for (ProgramImage image : images) {
                ps.setInt(1, image.getProgramId());
                ps.setString(2, image.getPath());
                ps.addBatch();
            }

            ps.executeBatch();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addScheduleImage(List<ScheduleImage> images) {
        try {
            String sql = "insert into schedule_img(schedule_id, schedule_img_path) values(?, ?)";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            // TOBE: Implement update based on batch size
            int BATCH_SIZE = 200;

            for (ScheduleImage image : images) {
                ps.setInt(1, image.getScheduleId());
                ps.setString(2, image.getPath());
                ps.addBatch();
            }

            ps.executeBatch();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addActivitiesImage(List<OperatorImage> images) {
        Connection conn;
        PreparedStatement ps;
        try {
            String sql = "insert into operator_activities_img values (?, ?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            for (OperatorImage image : images) {
                ps.setInt(1, image.getOperatorId());
                ps.setString(2, image.getPath());
                ps.addBatch();
            }

            ps.executeBatch();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addBillsImage(List<OperatorImage> images) {
        Connection conn;
        PreparedStatement ps;
        try {
            String sql = "insert into operator_bill_img values (?, ?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);

            for (OperatorImage image : images) {
                ps.setInt(1, image.getOperatorId());
                ps.setString(2, image.getPath());
                ps.addBatch();
            }

            ps.executeBatch();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<? extends Image> getImages(int id, String table) {

        switch (table) {
            case "program_img":
                return getProgramImages(id);
            case "schedule_img":
                return getScheduleImages(id);
            case "activies_img":
                return getActivitiesImage(id);
            case "bill_img":
                return getBillsImage(id);
            default:
                throw new Error("Table not found");
        }

    }

    public List<ProgramImage> getProgramImages(int programId) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<ProgramImage> images = new ArrayList();

        try {
            String query = "select * from program_img where program_id = ?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("program_img_id");
                String programImagePath = rs.getString("program_img_path");
                ProgramImage image = new ProgramImage(id, programImagePath, programId);
                images.add(image);
            }

            // close connection after execute query
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }

    public static List<ScheduleImage> getScheduleImages(int scheduleId) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<ScheduleImage> images = new ArrayList();

        try {
            String query = "select * from schedule_img where schedule_id = ?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, scheduleId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("schedule_img_id");
                String path = rs.getString("schedule_img_path");
                ScheduleImage image = new ScheduleImage(id, scheduleId, path);
                images.add(image);
            }

            // close connection after execute query
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }
    
    public static List<OperatorImage> getActivitiesImage(int operatorId) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<OperatorImage> images = new ArrayList();

        try {
            String query = "select * from operator_activities_img where operator_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, operatorId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("operator_actv_img_id");
                String path = rs.getString("operator_actv_img_path");
                OperatorImage image = new OperatorImage(id, operatorId, path);
                images.add(image);
            }

            // close connection after execute query
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }
    
     public static List<OperatorImage> getBillsImage(int operatorId) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<OperatorImage> images = new ArrayList();

        try {
            String query = "select * from operator_bill_img where operator_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, operatorId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("operator_bill_img_id");
                String path = rs.getString("operator_bill_img_path");
                OperatorImage image = new OperatorImage(id, operatorId, path);
                images.add(image);
            }

            // close connection after execute query
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }
     
     public void deleteImgByOperatorIds(String[] id) {
         
     }

    public static void main(String[] args) {
        ImageDAO dao = new ImageDAO();
        System.out.println(dao.getImages(1007, "activies_img"));
    }
}

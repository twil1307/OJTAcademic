/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import Image.ImageDAO;
import Program.ProgramImage;
import Schedule.Schedule.ScheduleBuilder;
import User.UserDAO;
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
public class ScheduleDAO {
    private final ImageDAO imageDao = new ImageDAO();
    
    public void updateSchedule(List<Schedule> schedules, boolean isNewScheduledAdded) {
        
        
        if (isNewScheduledAdded) {
            System.out.println("Adding new schedules");
            imageDao.deleteScheduleImage(schedules.get(0).getProgram_id());
            deleteScheduleByProgramId(schedules.get(0).getProgram_id());
            addSchedule(schedules);
        } else {
            schedules.forEach(schedule -> {
                if (schedule.getImgPath().size() > 0) {
                    imageDao.updateImage(schedule.getImgPath(), "schedule_img");
                }
             });
            
            try {
                System.out.println("Updating existed schedules");
                String sql = "update schedule "
                        + "set schedule_date = ?, "
                        + "schedule_detail_des = ? "
                        + "where schedule_id = ?";
                Connection conn = new DBContext().getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                // TOBE: Implement update based on batch size
                int BATCH_SIZE = 200;

                for (Schedule schedule : schedules) {
                    ps.setString(1, schedule.getDate());
                    ps.setString(2, schedule.getDetail_des());
                    ps.setInt(3, schedule.getSchedule_id());
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

    }
    
    public void deleteScheduleByProgramId(int programId) {
        try {
            String sql = "delete from schedule where program_id = ?";
            
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, programId);
            
            int deleteds = ps.executeUpdate();
            System.out.println("Deleted");
            System.out.println(deleteds);
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Schedule> addSchedule(List<Schedule> schedules) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        int index = 0;
        
        try {
            String query = "insert into schedule(program_id, schedule_date, schedule_detail_des) values(?, ?, ?)";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            for (Schedule schedule : schedules) {
                ps.setInt(1, schedule.getProgram_id());
                ps.setString(2, schedule.getDate());
                ps.setString(3, schedule.getDetail_des());
                ps.addBatch();
            }
            
            ps.executeBatch();
            query = "select schedule_id from schedule where program_id = ? order by schedule_date asc";
            ps = conn.prepareStatement(query);
            ps.setInt(1, schedules.get(index).getProgram_id());
            
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Schedule schedule = schedules.get(index);
                int scheduleId = rs.getInt(1);
                schedule.setSchedule_id(scheduleId);
                
                schedule.getImgPath().forEach(imgPath -> imgPath.setScheduleId(scheduleId));
                imageDao.addImage(schedule.getImgPath(), "schedule_img");
                index++;
            }
            
            // close connection after execute query
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return schedules;
    }
    
    public List<Schedule> getSchedulesByProgramId(int programId) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<Schedule> schedules = new ArrayList();
        ImageDAO imageDao = new ImageDAO();
        
        try {
            String query = "select * from schedule where program_id = ?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int id = rs.getInt("schedule_id");
                String date = rs.getString("schedule_date");
                String detailDes = rs.getString("schedule_detail_des");
                Schedule schedule = new ScheduleBuilder()
                                        .schedule_id(id)
                                        .date(date)
                                        .detail_des(detailDes)
                                        .program_id(programId)
                                        .build();
                List<ScheduleImage> images = (List<ScheduleImage>) imageDao.getImages(id, "schedule_img");
                schedule.setImgPath(images);
                schedules.add(schedule);
            }
            
            // close connection after execute query
            ps.close();
            conn.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return schedules;
    }
}

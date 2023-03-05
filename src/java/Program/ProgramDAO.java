/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Image.ImageDAO;
import User.UserDAO;
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
public class ProgramDAO {    
    
    public void addProgram(Program program) { 
        try {
            ImageDAO imageDao = new ImageDAO();
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            int generatedKey;
                
            
            
            String query = "insert into program(program_name, program_short_des,program_detail_des,goal_amount,start_date,end_date,sche_start_date,sche_end_date,account_id) values(?,?,?,?,?,?,?,?,?)";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, program.getProgramName());
            ps.setString(2, program.getShortDes());
            ps.setString(3, program.getDetailDes());
            ps.setDouble(4, program.getGoalAmount());
            ps.setString(5, program.getStartDate());
            ps.setString(6, program.getEndDate());
            ps.setString(7, program.getScheStartDate());
            ps.setString(8, program.getScheEndDate());
            ps.setInt(9, 2);
            
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            rs.next();
            generatedKey = rs.getInt(1);
            
            System.out.println("Adding new program with programId: " + generatedKey);

            program.getProgramImgs().stream().forEach(programImg -> {
                programImg.setProgramId(generatedKey);
                imageDao.addImage(programImg, "program_img");
            });
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

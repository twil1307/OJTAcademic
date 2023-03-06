package Program;

import Image.ImageDAO;
import Program.Program.Destination;
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
    
    public void addProgram(Program program)  { 
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ImageDAO imageDao = new ImageDAO();

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
            });
            
            imageDao.addImage(program.getProgramImgs(), "program_img");
            
            // insert destination into db
            Destination des = program.getDestination();
            query = "insert into destination(program_id, city, province, address) values(?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, generatedKey);
            ps.setString(2, des.getCity());
            ps.setString(3, des.getProvince());
            ps.setString(4, des.getAddress());
            
            ps.executeUpdate();
            
            // close connection after execute query
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

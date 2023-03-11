package Program;

import Image.ImageDAO;
import Program.Program.Destination;
import Program.Program.ProgramBuilder;
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


public class ProgramDAO {    
    
    public int addProgram(Program program)  { 
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ImageDAO imageDao = new ImageDAO();

            int generatedKey;

            String query = "insert into program(program_name, program_short_des,program_detail_des,goal_amount,start_date,end_date,sche_start_date,sche_end_date,account_id, is_closed) values(?,?,?,?,?,?,?,?,?, default)";
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
            ps.setInt(9, program.getUserId());
            
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
            return generatedKey;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0;
    }
    
    public Program getProgram(int programId) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        Program program = null;
        
        try {
            ImageDAO imageDao = new ImageDAO();

            String query = "select * from program where program_id = ?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                String programName = rs.getString("program_name");
                String shortDes = rs.getString("program_short_des");
                String detailDes = rs.getString("program_detail_des");
                double goalAmount = rs.getDouble("goal_amount");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String scheStartDate = rs.getString("sche_start_date");
                String scheEndDate = rs.getString("sche_end_date");
                int accountId = rs.getInt("account_id");
                
                program = new ProgramBuilder()
                        .programId(programId)
                        .programName(programName)
                        .shortDes(shortDes)
                        .detailDes(detailDes)
                        .goalAmount(goalAmount)
                        .startDate(startDate)
                        .endDate(endDate)
                        .scheEndDate(scheEndDate)
                        .scheStartDate(scheStartDate)
                        .userId(accountId)
                        .build();
            }
            
            Destination destination = getProgramDestination(programId, program);
            program.setDestination(destination);
            List<ProgramImage> images = (List<ProgramImage>) imageDao.getImages(programId, "program_img");
            program.setProgramImgs(images);
            
            // close connection after execute query
            ps.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return program;
    }
    
    private Destination getProgramDestination(int programId, Program program) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        Destination destination = null;
        
        try {
            String query = "select * from destination where program_id = ?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                int destinationId = rs.getInt("destination_id");
                String city = rs.getString("city");
                String province = rs.getString("province");
                String address = rs.getString("address");
                destination = program.new Destination(destinationId, city, province, address);
            }
            
            // close connection after execute query
            ps.close();
            conn.close();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return destination;
    }
    
    
    int getTotalProgram() {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select count(1) as total_program from program";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            int a = -1;
            while (rs.next()) {
                a=rs.getInt("total_program");
            }

            return a;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<Program> getListProgram(int beginElement, int size) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select *, (select top 1 program_img_path from program_img where program_id=pr.program_id) as display_img, (SELECT ISNULL((select sum(amount) from donate where program_id=pr.program_id), 0)) as raised_amount \n" +
                                        "from program as pr order by pr.start_date\n" +
                                        "offset ? rows fetch next ? rows only";
//            OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
            
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, beginElement);
            ps.setInt(2, size);
            
            
            rs = ps.executeQuery();

            List<Program> programs = new ArrayList<>();
            while (rs.next()) {
                Program newsAdd = new  ProgramVO(rs.getInt("program_id"), rs.getString("program_name"), rs.getString("program_short_des"), 
                                                                null, rs.getDouble("goal_amount"), rs.getString("start_date"), rs.getString("end_date"), null, null, null, rs.getInt("account_id"), 
                                                                null, rs.getString("display_img"), rs.getDouble("raised_amount"));
                                                                
                programs.add(newsAdd);
            }

            return programs;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        List<Program> listProgram = ProgramDAO.getListProgram(0, 6);
//        System.out.println(listProgram.size());
//    }

    double getProgramRaisedAmount(int programId) {
       try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select isnull((select sum(amount) from donate where program_id=?), 0) as raised_amount";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);
            rs = ps.executeQuery();

            int a = -1;
            while (rs.next()) {
                a=rs.getInt("raised_amount");
            }

            return a;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}

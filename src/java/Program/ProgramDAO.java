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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgramDAO {

    public int addProgram(Program program) {
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

            while (rs.next()) {
                String programName = rs.getString("program_name");
                String shortDes = rs.getString("program_short_des");
                String detailDes = rs.getString("program_detail_des");
                long goalAmount = rs.getLong("goal_amount");
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

            while (rs.next()) {
                int destinationId = rs.getInt("destination_id");
                String city = rs.getString("city");
                String province = rs.getString("province");
                String address = rs.getString("address");
                destination = program.new Destination(destinationId, city, province, address);
                program.setDestination(destination);
            }

            // close connection after execute query
            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return destination;
    }

    int getTotalProgram(Map<String, String> conditions) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select count(DISTINCT pr.program_id) as total_program\n"
                    + "from program pr, destination des, investor inv, donor dn where pr.program_id=des.program_id and pr.program_id=inv.program_id  and pr.account_id=dn.account_id and pr.is_closed='FALSE'";
            conn = new DBContext().getConnection();
            
            for (Map.Entry<String, String> entry : conditions.entrySet()) {

                switch (entry.getKey()) {
                    case "condition_authorName":
                        if (entry.getValue() != null) {
                            query += " and dn.name like '%" + entry.getValue() + " %'";
                        }
                        break;

                    case "condition_investorName":
                        if (entry.getValue() != null) {
                            query += " and inv.investor_name like '%" + entry.getValue() + "%'";
                        }
                        break;

                    case "condition_placeName":
                        if (entry.getValue() != null) {
                            query += " and (des.city like '%" + entry.getValue() + "%' OR des.province like '%" + entry.getValue() + "%' OR des.address like '%" + entry.getValue() + "%')";
                        }
                        break;

                    case "condition_programName":
                        if (entry.getValue() != null) {
                            query += " and pr.program_name like '%" + entry.getValue() + "%'";
                        }
                }
            }
            
            System.out.println(query);

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            int a = -1;
            while (rs.next()) {
                a = rs.getInt("total_program");
            }

            return a;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
     int getTotalProgramClosed(Map<String, String> conditions) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select count(DISTINCT pr.program_id) as total_program\n"
                    + "from program pr, destination des, investor inv, donor dn where pr.program_id=des.program_id and pr.program_id=inv.program_id  and pr.account_id=dn.account_id and pr.is_closed='TRUE'";
            conn = new DBContext().getConnection();
            
            for (Map.Entry<String, String> entry : conditions.entrySet()) {

                switch (entry.getKey()) {
                    case "condition_authorName":
                        if (entry.getValue() != null) {
                            query += " and dn.name like '%" + entry.getValue() + " %'";
                        }
                        break;

                    case "condition_investorName":
                        if (entry.getValue() != null) {
                            query += " and inv.investor_name like '%" + entry.getValue() + "%'";
                        }
                        break;

                    case "condition_placeName":
                        if (entry.getValue() != null) {
                            query += " and (des.city like '%" + entry.getValue() + "%' OR des.province like '%" + entry.getValue() + "%' OR des.address like '%" + entry.getValue() + "%')";
                        }
                        break;

                    case "condition_programName":
                        if (entry.getValue() != null) {
                            query += " and pr.program_name like '%" + entry.getValue() + "%'";
                        }
                }
            }
            
            System.out.println(query);

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            int a = -1;
            while (rs.next()) {
                a = rs.getInt("total_program");
            }

            return a;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    long getGoalAmountAll(String statusCase) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = null;

            switch (statusCase) {
                case "close":
                    query = "select ISNULL(sum(pr.goal_amount), 0) as total from program pr where pr.is_closed='TRUE'";
                    break;
                case "open":
                    query = "select ISNULL(sum(pr.goal_amount), 0) as total from program pr where pr.is_closed='FALSE'";
                    break;
                default:
                    query = "select ISNULL(sum(pr.goal_amount), 0) as total from program pr where pr.is_closed='FALSE'";
                    break;
            }

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            long a = -1;
            while (rs.next()) {
                a = rs.getLong("total");
            }

            return a;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        ProgramDAO dao = new ProgramDAO();
        System.out.println(dao.getGoalAmountAll("close"));
    }

    double getActutalAmountAll(String statusCase) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = null;

            switch (statusCase) {
                case "close":
                    query = "select ISNULL(sum(dn.amount), 0) as total from donate dn, program pr where dn.program_id=pr.program_id and pr.is_closed='TRUE'";
                    break;
                case "open":
                    query = "select ISNULL(sum(dn.amount), 0) as total from donate dn, program pr where dn.program_id=pr.program_id and pr.is_closed='FALSE'";
                    break;
                default:
                    query = "select ISNULL(sum(dn.amount), 0) as total from donate dn, program pr where dn.program_id=pr.program_id and pr.is_closed='FALSE'";
                    break;
            }

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            int a = -1;
            while (rs.next()) {
                a = rs.getInt("total");
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

            String query = "select *, (select top 1 program_img_path from program_img where program_id=pr.program_id) as display_img, (SELECT ISNULL((select sum(amount) from donate where program_id=pr.program_id), 0)) as raised_amount \n"
                    + "from program as pr where pr.is_closed='FALSE' order by pr.start_date\n"
                    + "offset ? rows fetch next ? rows only";
//            OFFSET ? ROWS FETCH NEXT ? ROWS ONLY

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, beginElement);
            ps.setInt(2, size);

            rs = ps.executeQuery();

            List<Program> programs = new ArrayList<>();
            while (rs.next()) {
                Program programAdd = new ProgramVO(rs.getInt("program_id"), rs.getString("program_name"), rs.getString("program_short_des"),
                        null, rs.getLong("goal_amount"), rs.getString("start_date"), rs.getString("end_date"), null, null, null, rs.getInt("account_id"),
                        null, rs.getString("display_img"), rs.getDouble("raised_amount"));

//                Destination destination = getProgramDestination(programAdd.getProgramId(), programAdd);
//                programAdd.setDestination(destination);
                programs.add(programAdd);
            }

            return programs;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Program> getListProgramWithCondition(int beginElement, int size, Map<String, String> conditions) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select DISTINCT pr.*, (select top 1 program_img_path from program_img where program_id=pr.program_id) as display_img, \n"
                    + "(SELECT ISNULL((select sum(amount) from donate where program_id=pr.program_id), 0)) as raised_amount \n"
                    + "from program pr, destination des, investor inv, donor dn where pr.program_id=des.program_id and pr.program_id=inv.program_id  and pr.account_id=dn.account_id and pr.is_closed='FALSE'";

            // classic way, loop a Map
            for (Map.Entry<String, String> entry : conditions.entrySet()) {

                switch (entry.getKey()) {
                    case "condition_authorName":
                        if (entry.getValue() != null) {
                            query += " and dn.name like '%" + entry.getValue() + "%'";
                        }
                        break;

                    case "condition_investorName":
                        if (entry.getValue() != null) {
                            query += " and inv.investor_name like '%" + entry.getValue() + "%'";
                        }
                        break;

                    case "condition_placeName":
                        if (entry.getValue() != null) {
                            query += " and (des.city like '%" + entry.getValue() + "%' OR des.province like '%" + entry.getValue() + "%' OR des.address like '%" + entry.getValue() + "%')";
                        }
                        break;

                    case "condition_programName":
                        if (entry.getValue() != null) {
                            query += " and pr.program_name like '%" + entry.getValue() + "%'";
                        }
                }
            }

            query += " order by pr.start_date \n"
                    + "offset ? rows fetch next ? rows only";

            System.out.println(query);

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, beginElement);
            ps.setInt(2, size);

            rs = ps.executeQuery();

            List<Program> programs = new ArrayList<>();
            while (rs.next()) {
                Program programAdd = new ProgramVO(rs.getInt("program_id"), rs.getString("program_name"), rs.getString("program_short_des"),
                        null, rs.getLong("goal_amount"), rs.getString("start_date"), rs.getString("end_date"), null, null, null, rs.getInt("account_id"),
                        null, rs.getString("display_img"), rs.getDouble("raised_amount"));

                Destination destination = getProgramDestination(programAdd.getProgramId(), programAdd);
                programAdd.setDestination(destination);
                programs.add(programAdd);
            }

            return programs;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Program> getListProgramClosedWithCondition(int beginElement, int size, Map<String, String> conditions) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select DISTINCT pr.*, (select top 1 program_img_path from program_img where program_id=pr.program_id) as display_img, \n"
                    + "(SELECT ISNULL((select sum(amount) from donate where program_id=pr.program_id), 0)) as raised_amount \n"
                    + "from program pr, destination des, investor inv, donor dn where pr.program_id=des.program_id and pr.program_id=inv.program_id  and pr.account_id=dn.account_id and pr.is_closed='TRUE'";

            // classic way, loop a Map
            for (Map.Entry<String, String> entry : conditions.entrySet()) {

                switch (entry.getKey()) {
                    case "condition_authorName":
                        if (entry.getValue() != null) {
                            query += " and dn.name like '%" + entry.getValue() + "%'";
                        }
                        break;

                    case "condition_investorName":
                        if (entry.getValue() != null) {
                            query += " and inv.investor_name like '%" + entry.getValue() + "%'";
                        }
                        break;

                    case "condition_placeName":
                        if (entry.getValue() != null) {
                            query += " and (des.city like '%" + entry.getValue() + "%' OR des.province like '%" + entry.getValue() + "%' OR des.address like '%" + entry.getValue() + "%')";
                        }
                        break;

                    case "condition_programName":
                        if (entry.getValue() != null) {
                            query += " and pr.program_name like '%" + entry.getValue() + "%'";
                        }
                }
            }

            query += " order by pr.start_date \n"
                    + "offset ? rows fetch next ? rows only";

            System.out.println(query);

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, beginElement);
            ps.setInt(2, size);

            rs = ps.executeQuery();

            List<Program> programs = new ArrayList<>();
            while (rs.next()) {
                Program programAdd = new ProgramVO(rs.getInt("program_id"), rs.getString("program_name"), rs.getString("program_short_des"),
                        null, rs.getLong("goal_amount"), rs.getString("start_date"), rs.getString("end_date"), null, null, null, rs.getInt("account_id"),
                        null, rs.getString("display_img"), rs.getDouble("raised_amount"));

                Destination destination = getProgramDestination(programAdd.getProgramId(), programAdd);
                programAdd.setDestination(destination);
                programs.add(programAdd);
            }

            return programs;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Program> getListProgramAllAvaiable() {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select *, (select top 1 program_img_path from program_img where program_id=pr.program_id) as display_img, (SELECT ISNULL((select sum(amount) from donate where program_id=pr.program_id), 0)) as raised_amount \n"
                    + "from program as pr order by pr.start_date";

//            OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            List<Program> programs = new ArrayList<>();
            while (rs.next()) {
                Program programAdd = new ProgramVO(rs.getInt("program_id"), rs.getString("program_name"), rs.getString("program_short_des"),
                        null, rs.getLong("goal_amount"), rs.getString("start_date"), rs.getString("end_date"), null, rs.getString("sche_start_date"), rs.getString("sche_end_date"), rs.getInt("account_id"),
                        null, rs.getString("display_img"), rs.getDouble("raised_amount"), rs.getString("is_closed"));

                Destination destination = getProgramDestination(programAdd.getProgramId(), programAdd);
                programAdd.setDestination(destination);
                programs.add(programAdd);
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
                a = rs.getInt("raised_amount");
            }

            return a;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void autoUpdate() {
        Connection conn;
        PreparedStatement ps;

        try {

            String query = "update program set is_closed = 'TRUE' where end_date<cast(getdate() as date)";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeProgram(int programId) {
        Connection conn;
        PreparedStatement ps;

        try {

            String query = "update program set is_closed='TRUE' where program_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openProgram(int programId) {
        Connection conn;
        PreparedStatement ps;

        try {

            String query = "update program set is_closed='FALSE' where program_id=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, programId);

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    public int updateProgram(Program program) {
        Connection conn;
        PreparedStatement ps;
        
        try {
            ImageDAO imageDao = new ImageDAO();
            int programId = program.getProgramId();

            String query = "update program "
                    + "set program_name = ?, "
                    + "program_short_des = ?, "
                    + "program_detail_des = ?, "
                    + "goal_amount = ?, "
                    + "start_date = ?, "
                    + "end_date = ?, "
                    + "sche_start_date = ?, "
                    + "sche_end_date = ? "
                    + "where program_id = ?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setString(1, program.getProgramName());
            ps.setString(2, program.getShortDes());
            ps.setString(3, program.getDetailDes());
            ps.setDouble(4, program.getGoalAmount());
            ps.setString(5, program.getStartDate());
            ps.setString(6, program.getEndDate());
            ps.setString(7, program.getScheStartDate());
            ps.setString(8, program.getScheEndDate());
            ps.setInt(9, programId);
            
            int result = ps.executeUpdate();

            System.out.println("Update existed program with affected rows " + result);

            if (program.getProgramImgs().size() > 0) {
                program.getProgramImgs().stream().forEach(programImg -> {
                    programImg.setProgramId(programId);
                });

                imageDao.updateImage(program.getProgramImgs(), "program_img");
            }
            
            // insert destination into db
            Destination des = program.getDestination();
            query = "update destination set city = ?, province = ?, address = ? where program_id = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, des.getCity());
            ps.setString(2, des.getProvince());
            ps.setString(3, des.getAddress());
            ps.setInt(4, programId);
            
            ps.executeUpdate();
            
            // close connection after execute query
            ps.close();
            conn.close();
            
            // return number of affected rows
            return result;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProgramDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return 0;
    }
}

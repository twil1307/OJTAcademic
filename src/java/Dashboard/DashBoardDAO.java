/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toten
 */
public class DashBoardDAO {

    public double getTotal(String totalCase) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            String query = null;

            switch (totalCase) {
                case "today":
                    query = "select sum(amount) as totalToday from donate WHERE CAST(donate_date AS DATE) = CAST(GETDATE() AS DATE)";
                    break;
                case "month":
                    query = "select sum(amount) as totalThisMonth from donate WHERE MONTH(donate_date) = MONTH(GETDATE())";
                    break;
                case "all":
                    query = "select sum(amount) as total from donate";
                    break;
                default:
                    query = "select sum(amount) as total from donate";
                    break;
            }

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                switch (totalCase) {
                    case "today":
                        return rs.getInt("totalToday");
                    case "month":
                        return rs.getInt("totalThisMonth");
                    case "all":
                        return rs.getInt("total");
                    default:
                        return rs.getInt("total");
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DashBoardDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashBoardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public double getTotalGoal() {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            String query = "select sum(goal_amount) as total_goal from program";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getDouble("total_goal") > (double) Integer.MAX_VALUE || rs.getDouble("total_goal") < (double) Integer.MIN_VALUE) {
                    System.out.println("bigger");
                    return 9999999;
                } else {
                    return rs.getDouble("total_goal");
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DashBoardDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DashBoardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static void main(String[] args) {
        DashBoardDAO dao = new DashBoardDAO();
        System.out.println(dao.getTotalGoal());
    }

}

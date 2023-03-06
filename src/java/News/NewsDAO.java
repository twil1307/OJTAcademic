/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

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
public class NewsDAO {

    public int createNews(News news) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "insert into news values (?, ?, GETDATE(), ?, ?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, news.getNewsTitle());
            ps.setString(2, news.getNewsDes());
            ps.setInt(3, news.getUserId());
            ps.setString(4, news.getShortDes());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();

            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public List<Integer> saveNewsImgs(News news) {
        Connection conn;
        PreparedStatement ps;
        ResultSet rs;
        List<Integer> generatedIds = new ArrayList<>();
        String INSERT_NEWS_IMG = "insert into news_img (news_id, news_img_path) values (?, ?)";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(INSERT_NEWS_IMG, Statement.RETURN_GENERATED_KEYS);

            conn.setAutoCommit(false);

            for (int i = 0; i < news.getImgsPath().size(); i++) {
                ps.setInt(1, news.getNewsId());
                ps.setString(2, news.getImgsPath().get(i));

                ps.addBatch();
            }

            int[] updateCounts = ps.executeBatch();
            rs = ps.getGeneratedKeys();

            while (rs.next()) {
                generatedIds.add(rs.getInt(1));
            }

            conn.commit();
            conn.setAutoCommit(true);

            return generatedIds;

        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}

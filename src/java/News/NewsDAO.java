/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

import context.DBContext;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Integer> saveNewsImgs(News news) throws SQLException {
        String INSERT_NEWS_IMG = "insert into news_img (news_id, news_img_path) values (?, ?)";

        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEWS_IMG)) {
            connection.setAutoCommit(false);
            for (int i = 0; i < news.getImgsPath().size(); i++) {
                preparedStatement.setInt(1, news.getNewsId());
                preparedStatement.setString(2, news.getImgsPath().get(i));

                preparedStatement.addBatch();
            }

            int[] updateCounts = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
            connection.commit();
            connection.setAutoCommit(true);
        } catch (BatchUpdateException batchUpdateException) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, batchUpdateException);
        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public News getSingleNews(Integer newsId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select news.*, (select top 1 news_img.news_img_path from news_img where news_img.news_id=news.news_id)as img , (select name from donor where donor.account_id=news.account_id) as createdBy from news where news.news_id=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, newsId);

            rs = ps.executeQuery();

            News news = null;
            while (rs.next()) {
                news = (new NewsVO(rs.getInt("news_id"), rs.getString("news_title"), rs.getString("news_des"), rs.getString("short_des"), rs.getString("post_date"), rs.getInt("account_id"), null, rs.getString("img"), rs.getString("createdBy")));
                
            }

            return news;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<String> getSingleNewsImgs(Integer newsId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select news_img_path from news_img where news_id=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, newsId);

            rs = ps.executeQuery();

            List<String> newsImg = new ArrayList<>();
            while (rs.next()) {
                
                newsImg.add(rs.getString("news_img_path"));
            }

            return newsImg;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<News> getListRecentNews(int currentNewsId) {

        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select top 10 news.*, (select top 1 news_img.news_img_path from news_img where news_img.news_id=news.news_id)as img , (select name from donor where donor.account_id=news.account_id) as createdBy from news where news.news_id not in (?) order by post_date desc";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, currentNewsId);

            rs = ps.executeQuery();

            List<News> news = new ArrayList<>();
            while (rs.next()) {
                News newsAdd =  new NewsVO(rs.getInt("news_id"), rs.getString("news_title"), rs.getString("news_des"), rs.getString("short_des"), rs.getString("post_date"), rs.getInt("account_id"), null, rs.getString("img"), rs.getString("createdBy"));
                
                news.add(newsAdd);
            }

            return news;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    List<News> getListNews(int beginElement, int size) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select news.*, (select top 1 news_img.news_img_path from news_img where news_img.news_id=news.news_id)as img , (select name from donor where donor.account_id=news.account_id) as createdBy from news order by post_date desc offset ? rows fetch next ? rows only";
//            OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
            
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);
            ps.setInt(1, beginElement);
            ps.setInt(2, size);
            
            
            rs = ps.executeQuery();

            List<News> news = new ArrayList<>();
            while (rs.next()) {
                News newsAdd =  new NewsVO(rs.getInt("news_id"), rs.getString("news_title"), rs.getString("news_des"), rs.getString("short_des"), rs.getString("post_date"), rs.getInt("account_id"), null, rs.getString("img"), rs.getString("createdBy"));
                
                news.add(newsAdd);
            }

            return news;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    int getTotalNews() {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;

            String query = "select count(1) as total_news from news";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            int a = -1;
            while (rs.next()) {
                a=rs.getInt("total_news");
            }

            return a;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    
    public void updateNews(News news) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "update news set news_title=?, news_des=?, post_date=GETDATE(), account_id=?, short_des=? where news_id=?";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            System.out.println(news);

            ps.setString(1, news.getNewsTitle());
            ps.setString(2, news.getNewsDes());
            ps.setInt(3, news.getUserId());
            ps.setString(4, news.getShortDes());
            ps.setInt(5, news.getNewsId());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void deleteNewsImages(int newsId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "delete from news_img where news_id=?";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, newsId);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void deleteNewsById(int newsId) {
        try {
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            
            String query = "delete from news where news_id=?";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);

            ps.setInt(1, newsId);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

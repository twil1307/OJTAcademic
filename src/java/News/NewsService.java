/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import shared.FileUploader;

/**
 *
 * @author toten
 */
public class NewsService {

    private final NewsDAO dao = new NewsDAO();

    public void createNews(News news, List<Part> newsImgParts, String path) {
        int newsId = dao.createNews(news);
        news.setNewsId(newsId);

        List<String> imgsPath = FileUploader.uploadImages(newsImgParts, news.getNewsTitle(), path);

        news.setImgsPath(imgsPath);

        try {
            dao.saveNewsImgs(news);
        } catch (SQLException ex) {
            Logger.getLogger(NewsService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateNews(News news, List<Part> newsImgParts, String path) {
        dao.updateNews(news);

        if (newsImgParts != null && path!=null && !newsImgParts.isEmpty()) {
            dao.deleteNewsImages(news.getNewsId());
            List<String> imgsPath = FileUploader.uploadImages(newsImgParts, news.getNewsTitle(), path);

            news.setImgsPath(imgsPath);

            try {
                dao.saveNewsImgs(news);
            } catch (SQLException ex) {
                Logger.getLogger(NewsService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public News getSingleNews(int newsId) {
        News news = dao.getSingleNews(newsId);
        List<String> newsImg = dao.getSingleNewsImgs(newsId);
        news.setImgsPath(newsImg);

        return news;
    }

    public List<News> getRecentNews(int currentNewsId) {
        return dao.getListRecentNews(currentNewsId);
    }

    public List<News> getListNews(int begin, int end) {
        return dao.getListNews(begin, end);
    }

    public int getTotalNews() {
        return dao.getTotalNews();
    }

    public void deleteNewsImages(int id) {
        dao.deleteNewsImages(id);
    }
    
    public void deleteNewsById(int id) {
        dao.deleteNewsById(id);
    }
}

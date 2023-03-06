/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

import java.util.List;
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

        List<String> imgsPath = FileUploader.uploadImagesReturnList(newsImgParts, news.getNewsTitle(), path);
        
        news.setImgsPath(imgsPath);
        
        dao.saveNewsImgs(news);
    }

//    void saveNewsImgs(List<String> newsImgs) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}

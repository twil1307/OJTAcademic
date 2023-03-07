/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

import java.util.List;

/**
 *
 * @author toten
 */
public class NewsVO extends News {
    
    private String backGroundImg;
    private String createdBy;
    
    public NewsVO(int newsId, String newsTitle, String newsDes, String shortDes, String postedDate, int userId, List<String> imgsPath) {
        super(newsId, newsTitle, newsDes, shortDes, postedDate, userId, imgsPath);
    }
    
    public NewsVO(int newsId, String newsTitle, String newsDes, String shortDes, String postedDate, int userId, List<String> imgsPath, String backGroundImg, String createdBy) {
        super(newsId, newsTitle, newsDes, shortDes, postedDate, userId, imgsPath);
        this.backGroundImg=backGroundImg;
        this.createdBy=createdBy;
    }

    public String getBackGroundImg() {
        return backGroundImg;
    }

    public void setBackGroundImg(String backGroundImg) {
        this.backGroundImg = backGroundImg;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    

    @Override
    public String toString() {
        return "NewsVO{" + "backGroundImg=" + backGroundImg + '}';
    }
    
    
    
}

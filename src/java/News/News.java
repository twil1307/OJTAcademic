/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package News;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author toten
 */
@Builder
@Getter
@Setter
@ToString
public class News {
    private int newsId;
    private String newsTitle;
    private String newsDes;
    private String shortDes;
    private Date postedDate;
    private int userId;
    private List<String> imgsPath;
}

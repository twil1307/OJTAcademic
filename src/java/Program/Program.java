/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

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
public class Program {
    private int programId;
    private String programName;
    private String shortDes;
    private String detailDes;
    private double goalAmount;
    private Date startDate;
    private Date endDate;
    private String city;
    private String province;
    private String address;
    private Date scheStartDate;
    private Date scheEndDate;
    private int userId;
    private List<String> programImgs;
}

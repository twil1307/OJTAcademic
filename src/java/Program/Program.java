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
    private String startDate;
    private String endDate;
    private Destination destination;
    private String scheStartDate;
    private String scheEndDate;
    private int userId;
    private List<ProgramImage> programImgs;
    
    @Getter
    @Setter
    @ToString
    class Destination {
        private int id;
        private String city;
        private String province;
        private String address;
        
        public Destination(int id, String city, String province, String address) {
            this.id = id;
            this.city = city;
            this.province = province;
            this.address = address;
        }
    }
}

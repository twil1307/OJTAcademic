/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProgramVO extends Program {
    private String programDisplayImg;
    private double raisedAmount;

    public ProgramVO(int programId, String programName, String shortDes, String detailDes, double goalAmount, String startDate, String endDate, Destination destination, String scheStartDate, String scheEndDate, int userId, List<ProgramImage> programImgs, String programDisplayImg, double raisedAmount) {
        super(programId, programName, shortDes, detailDes, goalAmount, startDate, endDate, destination, scheStartDate, scheEndDate, userId, programImgs);
        this.programDisplayImg = programDisplayImg;
        this.raisedAmount = raisedAmount;
    }
    
}

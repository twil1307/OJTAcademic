/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProgramVO extends Program {

    private String programDisplayImg;
    private double raisedAmount;
    private String isClosed;
    private String isOutDate;
    private String city;
    private String province;
    private String address;

    public ProgramVO(int programId, String programName, String shortDes, String detailDes, double goalAmount, String startDate, String endDate, Destination destination, String scheStartDate, String scheEndDate, int userId, List<ProgramImage> programImgs, String programDisplayImg, double raisedAmount) {
        super(programId, programName, shortDes, detailDes, goalAmount, startDate, endDate, destination, scheStartDate, scheEndDate, userId, programImgs);
        this.programDisplayImg = programDisplayImg;
        this.raisedAmount = raisedAmount;
    }


    public ProgramVO(int programId, String programName, String shortDes, String detailDes, double goalAmount, String startDate, String endDate, Destination destination, String scheStartDate, String scheEndDate, int userId, List<ProgramImage> programImgs, String programDisplayImg, double raisedAmount, String isClosed) {
        super(programId, programName, shortDes, detailDes, goalAmount, startDate, endDate, destination, scheStartDate, scheEndDate, userId, programImgs);
        this.programDisplayImg = programDisplayImg;
        this.raisedAmount = raisedAmount;
        this.isClosed = isClosed;
        this.isOutDate = isOutDateSetter(endDate);
    }

    private String isOutDateSetter(String endDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dayEnd = dateFormat.parse(endDate);

            Calendar dateCalendar = Calendar.getInstance();
            dateCalendar.setTime(dayEnd);

            Calendar todayCalendar = Calendar.getInstance();
            todayCalendar.set(Calendar.HOUR_OF_DAY, 0);
            todayCalendar.set(Calendar.MINUTE, 0);
            todayCalendar.set(Calendar.SECOND, 0);
            todayCalendar.set(Calendar.MILLISECOND, 0);

            int compareValue = dateCalendar.compareTo(todayCalendar);
            System.out.println(compareValue);

            if (compareValue < 0) {
                return "TRUE";
            } else if (compareValue > 0) {
                return "FALSE";
            } else {
                return "HAHA";
            }

        } catch (ParseException ex) {
            return null;
        }
    }

}

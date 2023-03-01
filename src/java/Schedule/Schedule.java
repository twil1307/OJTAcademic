/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Schedule;

import java.util.Date;
import java.util.List;

/**
 *
 * @author toten
 */
public class Schedule {
    private int schedule_id;
    private int program_id;
    private Date date;
    private String detail_des;
    private List<String> imgPath;

    public Schedule(int schedule_id, int program_id, Date date, String detail_des) {
        this.schedule_id = schedule_id;
        this.program_id = program_id;
        this.date = date;
        this.detail_des = detail_des;
    }

    public Schedule(int schedule_id, int program_id, Date date, String detail_des, List<String> imgPath) {
        this.schedule_id = schedule_id;
        this.program_id = program_id;
        this.date = date;
        this.detail_des = detail_des;
        this.imgPath = imgPath;
    }

    public Schedule() {
    }

    public List<String> getImgPath() {
        return imgPath;
    }

    public void setImgPath(List<String> imgPath) {
        this.imgPath = imgPath;
    }
    
    

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail_des() {
        return detail_des;
    }

    public void setDetail_des(String detail_des) {
        this.detail_des = detail_des;
    }

    @Override
    public String toString() {
        return "Schedule{" + "schedule_id=" + schedule_id + ", program_id=" + program_id + ", date=" + date + ", detail_des=" + detail_des + '}';
    }
    
    
}
